package com.example.secondpract.model;

public class ProductModel {
    private int _id;
    private String _productName;
    private double _price;
    private String _category;

    public ProductModel() {}

    public ProductModel(int id, String productName, double price, String category) {
        _id = id;
        _productName = productName;
        _price = price;
        _category = category;
    }

    public String getProductName() {
        return _productName;
    }

    public void setProductName(String productName) {
        this._productName = productName;
    }

    public int getId() {
        return _id;
    }

    public void setId(int id) {
        this._id = id;
    }

    public double getPrice() {
        return _price;
    }

    public void setPrice(double price) {
        this._price = price;
    }

    public String getCategory() {
        return _category;
    }

    public void setCategory(String category) {
        this._category = category;
    }
}
