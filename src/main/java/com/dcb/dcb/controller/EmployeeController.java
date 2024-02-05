package com.dcb.dcb.controller;

import com.dcb.dcb.model.Employee;
import com.dcb.dcb.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public Employee save(@RequestBody Employee employee) {
        return employeeService.save(employee);
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{employeeId}")
    public Employee getEmployeeById(@PathVariable String employeeId) {
        return employeeService.getEmployeeById(employeeId);
    }

    @DeleteMapping("/{employeeId}")
    public String deleteEmployee(@PathVariable String employeeId) {
        return employeeService.deleteEmployee(employeeId);
    }

}
