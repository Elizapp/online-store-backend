package edu.miu.cs545.project.onlinestore.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin
@RestController
@RequestMapping("api/orders")
public class OrderController {

//    @Autowired
//    IBuyerService buyerService;
//
//    @Autowired
//    private IOrderService orderService;

//    @GetMapping("/{orderId}")
//    public @ResponseBody
//    Order getOrderById(@PathVariable long orderId) { //checked
//        Optional<Order> orderOptional = orderService.getOrderById(orderId);
//        if (orderOptional.isPresent()) {
//            return modelMapper.map(orderOptional.get(), Order.class);
//        }
//        return null;
//    }

//    @PostMapping()
//    public Order createOrder(@RequestBody Order order) {    //checked
//       return orderService.createOrder(order);
//    }   //checked


//    @GetMapping("/{orderId}/cancel")
//    public @ResponseBody
//    Boolean cancelOrder(@PathVariable long orderId) {
//        return orderService.cancelOrder(orderId);
//    }
//
//    public String getOrderStatus(long orderId) {
//        return orderService.getOrderStatus(orderId);
//    }
//
//    public List<OrderLine> getOrderLineById(long orderId) {
//        return orderService.getOrderLineById(orderId);
//    }
//
//    @GetMapping
//    public List<Order> getOrderForBuyer() {
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        UserDetailsImpl userdetails = (UserDetailsImpl) auth.getPrincipal();
//        Optional<Buyer> buyer = buyerService.findAll().stream().filter(x -> x.getUser().getUsername().equalsIgnoreCase(userdetails.getUsername())).findFirst();
//        if (buyer.isPresent()) {
//            List<Order> orders = orderService.getOrderForBuyer(buyer.get().getId());
//            return orders.stream()
//                    .map(p -> modelMapper.map(p, Order.class))
//                    .collect(Collectors.toList());
//        }
//        return null;
//    }

//    @GetMapping("/export/pdf")
//    public ResponseEntity exportToPDF() throws DocumentException, IOException {
//        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
//        String currentDateTime = dateFormatter.format(new Date());
//
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        UserDetailsImpl userdetails = (UserDetailsImpl) auth.getPrincipal();
//        Optional<Buyer> buyer = buyerService.findAll().stream().filter(x -> x.getUser().getUsername().equalsIgnoreCase(userdetails.getUsername())).findFirst();
//        if (buyer.isPresent()) {
//            List<Order> orders = orderService.getOrderForBuyer(buyer.get().getId());
//            List<Order> orderDTOS = orders.stream()
//                    .map(p -> modelMapper.map(p, Order.class))
//                    .collect(Collectors.toList());
//            OrderPDFExporter exporter = new OrderPDFExporter(orderDTOS);
//            ByteArrayInputStream bis = exporter.export();
//            HttpHeaders headers = new HttpHeaders();
//            headers.add("Content-Disposition", "inline; filename=orders.pdf");
//            return ResponseEntity
//                    .ok()
//                    .headers(headers)
//                    .contentType(MediaType.APPLICATION_PDF)
//                    .body(new InputStreamResource(bis));
//
//
//        }
//        return null;
//
//    }

//    public void createOrderFromCart(Long cartId, Shipping shipping, Payment payment) {
//        orderService.createOrderFromCart(cartId, shipping, payment);
//    }

}
