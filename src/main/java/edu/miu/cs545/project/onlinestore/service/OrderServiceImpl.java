package edu.miu.cs545.project.onlinestore.service;


import edu.miu.cs545.project.onlinestore.domain.*;
import edu.miu.cs545.project.onlinestore.repository.BuyerRepository;
import edu.miu.cs545.project.onlinestore.repository.OrderLineRepository;
import edu.miu.cs545.project.onlinestore.repository.OrderRepository;
import edu.miu.cs545.project.onlinestore.repository.ShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderLineRepository orderLineRepository;


    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    BuyerRepository buyerRepository;

    @Autowired
    private ShippingService shippingService;

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private ShoppingCartService shoppingCartService;

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    @Override
    public String getOrderStatus(long orderId){//checked
        return orderRepository.findById(orderId).get().getCurrentStatus();
    }

    @Override
    public Optional<Order> getOrderById(long orderId){
        return orderRepository.findById(orderId);   //checked
    }

    @Override
    public List<Order> getOrderForBuyer(long buyerId) {
        return orderRepository.findAllByBuyerId(buyerId);
    }


    @Override
    public Order createOrder(Order newOrder){
        return orderRepository.save(newOrder);
    } //checked

    @Override
    public List<OrderLine> getOrderLineById(long orderId){
        List<OrderLine> listOrderLine = new ArrayList<>();
        return orderLineRepository.getOrderLineById(orderId);
    }

    @Override
    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    @Override
    public Boolean cancelOrder(long orderId) {
        Order order = orderRepository.findOrderById(orderId);
        if(order != null)
        {
            order.setCurrentStatus("CANCELLED");
            orderRepository.save(order);
            return true;
        }
        return false;
    }

    @Override
    public List<Order> getOrderBySellerId(long sellerId) {

        List<OrderLine> lines = orderLineRepository.findAll().stream().filter(orderLine -> orderLine.getProduct().getSeller().getId() == sellerId).collect(Collectors.toList());

        List<Long> ids = lines.stream().map( orderLine->orderLine.getId()).collect(Collectors.toList());
        List<Order> orders = orderRepository.findAll().stream().filter(ord->ids.contains(ord.getId())).collect(Collectors.toList());
        return orders;
    }


    void sendEmail(String emailAddress, Order order) {
        try {
            SimpleMailMessage msg = new SimpleMailMessage();
            msg.setTo(emailAddress, emailAddress);

            msg.setSubject("Purchase was successful");
            String content = "";
            content += order.getId() + "\n";
            content += order.getOrderDate().toString() + "\n";
            content += order.getPayment().getPaymentMethod() + "\n";
            content += order.getTotalMoney().toString() + "\n";
            content += order.getShipping().toString() + "\n";
            content += "THANK YOU FOR SHOPPING WITH US.";
            msg.setText(content);

            javaMailSender.send(msg);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Boolean shippedOrder(long orderId) {
        Order order = orderRepository.findOrderById(orderId);
        if(order != null)
        {
            order.setCurrentStatus("SHIPPED");
            orderRepository.save(order);
            return true;
        }
        return false;
    }

    @Override
    public Boolean deliveredOrder(long orderId) {
        Order order = orderRepository.findOrderById(orderId);
        if(order != null)
        {
            order.setCurrentStatus("DELIVERED");
            orderRepository.save(order);
            return true;
        }
        return false;
    }

    public void createOrderFromCart(Long cartId, Shipping shipping, Payment payment){
        Order order = new Order();
        Payment paymentData = paymentService.createPayment(payment);
        Shipping shippingNew = shippingService.createShipping(shipping);
        Optional<ShoppingCart> cart = shoppingCartService.getShoppingCart(cartId);
        if(cart.isPresent()){
            ShoppingCart cart1 = cart.get();
            order.setCurrentStatus("NEW");
            order.setOrderDate(LocalDate.now());
            order.setShipping(shippingNew);
            order.setPayment(paymentData);
            order.setTotalMoney(cart1.getTotalMoney());
            order.setBuyer(cart1.getBuyer());
            List<ShoppingCartLine> cartLines = shoppingCartService.getLinesByShoppingCart(cartId);
            cartLines.forEach(cartline -> {
                OrderLine orderLine = createOrderLineFromCartLine(cartline);
                orderLine.setOrder(order);
                orderLineRepository.save(orderLine);
            });

            Order orderNew = orderRepository.save(order);

            cart1.setCompleted(true);
            Buyer buyer = cart1.getBuyer();
            buyer.setAccumulatedPoints(buyer.getAccumulatedPoints() + 10);
            buyerRepository.save(buyer);//adding point for buyer.

            shoppingCartRepository.save(cart1);
            sendEmail(buyer.getUser().getEmail(),orderNew);
        }
    }

    private OrderLine createOrderLineFromCartLine(ShoppingCartLine cartLine){
        OrderLine line = new OrderLine();
        line.setProduct(cartLine.getProduct());
        line.setPrice(cartLine.getPrice());
        line.setLineTotal(cartLine.getLineTotal());
        line.setQuantity(cartLine.getQuantity());
        return line;
    }
}
