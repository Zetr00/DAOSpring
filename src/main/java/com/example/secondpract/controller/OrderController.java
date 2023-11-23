package com.example.secondpract.controller;

import com.example.secondpract.dao.OrderDAO;
import com.example.secondpract.model.OrderModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/orders")
public class OrderController {

    private OrderDAO _orderDAO;

    @Autowired
    public OrderController(OrderDAO orderDAO) {
        _orderDAO = orderDAO;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("orders", _orderDAO.index());
        return "orders/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("order", _orderDAO.show(id));
        return "orders/show";
    }

    @GetMapping("/new")
    public String newOrder(@ModelAttribute("order") OrderModel orderModel) {
        return "orders/new";
    }

    @PostMapping()
    public String createOrder(@ModelAttribute("order") OrderModel orderModel) {
        _orderDAO.save(orderModel);
        return "redirect:/orders";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("order", _orderDAO.show(id));
        return "orders/edit";
    }

    @PostMapping("/update/{id}")
    public String updateOrder(@ModelAttribute("order") OrderModel orderModel, @PathVariable("id") int id) {
        _orderDAO.update(id, orderModel);
        return "redirect:/orders";
    }

    @PostMapping("/delete/{id}")
    public String deleteOrder(@PathVariable("id") int id) {
        _orderDAO.delete(id);
        return "redirect:/orders";
    }
}