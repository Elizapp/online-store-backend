package edu.miu.cs545.project.onlinestore.service;

import edu.miu.cs545.project.onlinestore.domain.Order;
import edu.miu.cs545.project.onlinestore.domain.OrderLine;
import edu.miu.cs545.project.onlinestore.domain.Payment;
import edu.miu.cs545.project.onlinestore.domain.Shipping;

import java.util.List;
import java.util.Optional;

public interface OrderService {

    public Optional<Order> getOrderById(long orderId);
    
    public String getOrderStatus(long orderId);

    public Order createOrder(Order newOrder);

    List<Order> getOrderForBuyer(long buyerId);
    List<Order> getAll();
    public List<OrderLine> getOrderLineById(long orderId);

    List<Order> getOrderBySellerId(long sellerId);

    Boolean cancelOrder(long orderId);
    Boolean shippedOrder(long orderId);
    Boolean deliveredOrder(long orderId);

    void createOrderFromCart(Long cartId, Shipping shipping, Payment payment);
}