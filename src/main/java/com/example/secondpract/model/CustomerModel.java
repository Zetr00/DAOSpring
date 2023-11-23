package com.example.secondpract.model;

public class CustomerModel {
    private int _id;
    private String _firstName;
    private String _lastName;
    private String _address;

    public CustomerModel() {
    }

    public CustomerModel(int id, String firstName, String lastName, String address) {
        _id = id;
        _firstName = firstName;
        _lastName = lastName;
        _address = address;
    }

    public int getId() {
        return _id;
    }

    public String getFirstName() {
        return _firstName;
    }

    public String getLastName() {
        return _lastName;
    }

    public String getAddress() {
        return _address;
    }

    public void setId(int id) {
        this._id = id;
    }

    public void setFirstName(String firstName) {
        this._firstName = firstName;
    }

    public void setLastName(String lastName) {
        this._lastName = lastName;
    }

    public void setAddress(String address) {
        this._address = address;
    }
}
