package com.example.secondpract.controller;

import com.example.secondpract.dao.CustomerDAO;
import com.example.secondpract.model.CustomerModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/customer")
public class CustomerController {

    private CustomerDAO _customerDAO;

    @Autowired
    public CustomerController(CustomerDAO customerDAO) {
        _customerDAO = customerDAO;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("customer", _customerDAO.index());
        return "customer/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("customer", _customerDAO.show(id));
        return "customer/show";
    }

    @GetMapping("/new")
    public String newCustomer(@ModelAttribute("customer") CustomerModel customerModel) {
        return "customer/new";
    }

    @PostMapping()
    public String createCustomer(@ModelAttribute("customer") CustomerModel customerModel) {
        _customerDAO.save(customerModel);
        return "redirect:/customer";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("customer", _customerDAO.show(id));
        return "customer/edit";
    }

    @PostMapping("/update/{id}")
    public String updateCustomer(@ModelAttribute("customer") CustomerModel customerModel, @PathVariable("id") int id) {
        _customerDAO.update(id, customerModel);
        return "redirect:/customer";
    }

    @PostMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable("id") int id) {
        _customerDAO.delete(id);
        return "redirect:/customer";
    }
}
