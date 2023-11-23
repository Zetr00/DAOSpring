package com.example.secondpract.dao;

import com.example.secondpract.model.EmployeeModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeDAO {
    private static int EMPLOYEE_COUNT;
    private List<EmployeeModel> employees;

    {
        employees = new ArrayList<>();

        employees.add(new EmployeeModel(++EMPLOYEE_COUNT, "John Doe", "Manager", 50000.0));
        employees.add(new EmployeeModel(++EMPLOYEE_COUNT, "Jane Smith", "Developer", 60000.0));
        employees.add(new EmployeeModel(++EMPLOYEE_COUNT, "Bob Johnson", "Designer", 55000.0));
        employees.add(new EmployeeModel(++EMPLOYEE_COUNT, "Umar OI", "Developer", 60000.0));
    }

    public List<EmployeeModel> index() {
        return employees;
    }

    public EmployeeModel show(int id) {
        return employees.stream().filter(employee -> employee.getId() == id).findAny().orElse(null);
    }

    public void save(EmployeeModel employee) {
        employee.setId(++EMPLOYEE_COUNT);
        employees.add(employee);
    }

    public void update(int id, EmployeeModel employeeModel) {
        EmployeeModel updateEmployee = show(id);
        updateEmployee.setName(employeeModel.getName());
        updateEmployee.setPosition(employeeModel.getPosition());
        updateEmployee.setSalary(employeeModel.getSalary());
    }

    public void delete(int id) {
        employees.removeIf(e -> e.getId() == id);
    }
}
