package edu.miu.cs545.project.onlinestore.service;

import edu.miu.cs545.project.onlinestore.domain.Order;
import edu.miu.cs545.project.onlinestore.domain.OrderLine;
import edu.miu.cs545.project.onlinestore.domain.Payment;
import edu.miu.cs545.project.onlinestore.domain.Shipping;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    List<Order> getOrderForBuyer(long buyerId);
    public String getOrderStatus(long orderId);
    Boolean shippedOrder(long orderId);
    List<Order> getAll();
    Boolean deliveredOrder(long orderId);
    Boolean cancelOrder(long orderId);
    List<Order> getOrderBySellerId(long sellerId);
    void createOrderFromCart(Long cartId, Shipping shipping, Payment payment);
}