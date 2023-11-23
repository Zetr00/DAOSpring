package com.example.secondpract.model;

public class OrderModel {
    private int _id;
    private int _productId;
    private int _quantity;
    private double _totalPrice;

    public OrderModel() {}

    public OrderModel(int id, int productId, int quantity, double totalPrice) {
        _id = id;
        _productId = productId;
        _quantity = quantity;
        _totalPrice = totalPrice;
    }

    public int getId() {
        return _id;
    }

    public void setId(int id) {
        this._id = id;
    }

    public int getProductId() {
        return _productId;
    }

    public void setProductId(int productId) {
        this._productId = productId;
    }

    public int getQuantity() {
        return _quantity;
    }

    public void setQuantity(int quantity) {
        this._quantity = quantity;
    }

    public double getTotalPrice() {
        return _totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this._totalPrice = totalPrice;
    }
}
