package com.example.secondpract.model;

public class UserModel {

    private int _id;
    private String _username;
    private String _email;
    private String _password;

    public  UserModel(){}

    public UserModel(int id, String username, String email, String password){
        _id = id;
        _username = username;
        _email = email;
        _password = password;
    }

    public String getUsername() {
        return _username;
    }

    public void setUsername(String username) {
        this._username = username;
    }

    public int getId() {
        return _id;
    }

    public void setId(int id) {
        this._id = id;
    }

    public String getEmail() {
        return _email;
    }

    public void setEmail(String email) {
        this._email = email;
    }

    public String getPassword() {
        return _password;
    }

    public void setPassword(String password) {
        this._password = password;
    }
}
