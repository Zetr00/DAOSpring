package com.example.secondpract.controller;

import com.example.secondpract.dao.EmployeeDAO;
import com.example.secondpract.model.EmployeeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeDAO _employeeDAO;

    @Autowired
    public EmployeeController(EmployeeDAO employeeDAO) {
        _employeeDAO = employeeDAO;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("employees", _employeeDAO.index());
        return "employees/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("employee", _employeeDAO.show(id));
        return "employees/show";
    }

    @GetMapping("/new")
    public String newEmployee(@ModelAttribute("employee") EmployeeModel employeeModel) {
        return "employees/new";
    }

    @PostMapping()
    public String createEmployee(@ModelAttribute("employee") EmployeeModel employeeModel) {
        _employeeDAO.save(employeeModel);
        return "redirect:/employees";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("employee", _employeeDAO.show(id));
        return "employees/edit";
    }

    @PostMapping("/update/{id}")
    public String updateEmployee(@ModelAttribute("employee") EmployeeModel employeeModel, @PathVariable("id") int id) {
        _employeeDAO.update(id, employeeModel);
        return "redirect:/employees";
    }

    @PostMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable("id") int id) {
        _employeeDAO.delete(id);
        return "redirect:/employees";
    }
}