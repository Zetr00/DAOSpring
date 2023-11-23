package com.example.secondpract.controller;

import com.example.secondpract.dao.UserDAO;
import com.example.secondpract.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {

    private UserDAO _userDAO;

    @Autowired
    public UserController(UserDAO userDAO) {
        _userDAO = userDAO;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("users", _userDAO.index());
        return "users/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", _userDAO.show(id));
        return "users/show";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") UserModel userModel) {
        return "users/new";
    }

    @PostMapping()
    public String createUser(@ModelAttribute("user") UserModel userModel) {
        _userDAO.save(userModel);
        return "redirect:/users";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", _userDAO.show(id));
        return "users/edit";
    }

    @PostMapping("/update/{id}")
    public String updateUser(@ModelAttribute("user") UserModel userModel, @PathVariable("id") int id) {
        _userDAO.update(id, userModel);
        return "redirect:/users";
    }

    @PostMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        _userDAO.delete(id);
        return "redirect:/users";
    }
}

