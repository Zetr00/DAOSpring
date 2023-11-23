package com.example.secondpract.dao;

import com.example.secondpract.model.CustomerModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class CustomerDAO {
    private static int CUSTOMER_COUNT;
    private List<CustomerModel> customer;

    {
        customer = new ArrayList<>();

        customer.add(new CustomerModel(++CUSTOMER_COUNT, "John", "Doe", "123 Main St"));
        customer.add(new CustomerModel(++CUSTOMER_COUNT, "Jane", "Smith", "456 Oak St"));
        customer.add(new CustomerModel(++CUSTOMER_COUNT, "On", "Smith", "452 Oak St"));
        customer.add(new CustomerModel(++CUSTOMER_COUNT, "Bob", "Johnson", "789 Maple St"));
    }

    public List<CustomerModel> index() {
        return customer;
    }

    public CustomerModel show(int id) {
        return customer.stream().filter(customer -> customer.getId() == id).findAny().orElse(null);
    }

    public void save(CustomerModel Customer) {
        Customer.setId(++CUSTOMER_COUNT);
        customer.add(Customer);
    }

    public void update(int id, CustomerModel customerModel) {
        CustomerModel updateCustomer = show(id);
        updateCustomer.setFirstName(customerModel.getFirstName());
        updateCustomer.setLastName(customerModel.getLastName());
        updateCustomer.setAddress(customerModel.getAddress());
    }

    public void delete(int id) {
        customer.removeIf(c -> c.getId() == id);
    }
}
