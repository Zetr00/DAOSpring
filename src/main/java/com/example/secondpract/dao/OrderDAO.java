package com.example.secondpract.dao;

import com.example.secondpract.model.OrderModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderDAO {
    private static int ORDER_COUNT;
    private List<OrderModel> orders;

    {
        orders = new ArrayList<>();

        orders.add(new OrderModel(++ORDER_COUNT, 1, 2, 69.98));
        orders.add(new OrderModel(++ORDER_COUNT, 2, 1, 49.99));
        orders.add(new OrderModel(++ORDER_COUNT, 1, 2, 69.98));
        orders.add(new OrderModel(++ORDER_COUNT, 2, 1, 49.99));
    }

    public List<OrderModel> index() {
        return orders;
    }

    public OrderModel show(int id) {
        return orders.stream().filter(order -> order.getId() == id).findAny().orElse(null);
    }

    public void save(OrderModel order) {
        order.setId(++ORDER_COUNT);
        orders.add(order);
    }

    public void update(int id, OrderModel orderModel) {
        OrderModel updateOrder = show(id);
        updateOrder.setProductId(orderModel.getProductId());
        updateOrder.setQuantity(orderModel.getQuantity());
        updateOrder.setTotalPrice(orderModel.getTotalPrice());
    }

    public void delete(int id) {
        orders.removeIf(o -> o.getId() == id);
    }
}
