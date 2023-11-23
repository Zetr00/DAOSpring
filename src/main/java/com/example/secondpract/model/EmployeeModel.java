package com.example.secondpract.model;

public class EmployeeModel {
    private int _id;
    private String _name;
    private String _position;
    private double _salary;

    public EmployeeModel() {}

    public EmployeeModel(int id, String name, String position, double salary) {
        _id = id;
        _name = name;
        _position = position;
        _salary = salary;
    }

    public int getId() {
        return _id;
    }

    public void setId(int id) {
        this._id = id;
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        this._name = name;
    }

    public String getPosition() {
        return _position;
    }

    public void setPosition(String position) {
        this._position = position;
    }

    public double getSalary() {
        return _salary;
    }

    public void setSalary(double salary) {
        this._salary = salary;
    }
}
