package org.pmf.rzk.orderservice.service;

import org.pmf.rzk.orderservice.feign.BookProxy;
import org.pmf.rzk.orderservice.model.Order;
import org.pmf.rzk.orderservice.repo.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private BookProxy bookProxy;

    public Order createOrder(Long userId, Long bookId, Integer quantity) {

        Double bookPrice = bookProxy.getBookById(bookId).getPrice();
        Double totalPrice = bookPrice * quantity;

        Order order = new Order();
        order.setUserId(userId);
        order.setBookId(bookId);
        order.setQuantity(quantity);
        order.setTotalPrice(BigDecimal.valueOf(totalPrice));
        order.setStatus("***PENDING***");

        return orderRepository.save(order);
    }

    public List<Order> getOrdersByUser(Long userId) {
        return orderRepository.findByUserId(userId);
    }

    public Order updateOrderStatus(Long orderId, String status) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Nije pronadjena narudzbina"));
        order.setStatus(status);
        return orderRepository.save(order);
    }
}
