package com.dcb.dcb.service;

import com.dcb.dcb.exception.EmployeeNotFoundException;
import com.dcb.dcb.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    List<Employee> employeeList = new ArrayList<>();
    @Override
    public Employee save(Employee employee) {
        if (employee.getEmployeeId() == null) {
            employee.setEmployeeId(UUID.randomUUID().toString());
        }
        employeeList.add(employee);
        return employee;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeList;
    }

    @Override
    public Employee getEmployeeById(String employeeId) {
        return employeeList
                .stream()
                .filter(employee -> employee.getEmployeeId().equals(employeeId))
                .findFirst()
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found with employeeId: " + employeeId));
    }

    @Override
    public String deleteEmployee(String employeeId) {
        Employee employee = employeeList
                .stream()
                .filter(e -> e.getEmployeeId().equals(employeeId))
                .findFirst()
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found with employeeId: " + employeeId));
        employeeList.remove(employee);
        return "Employee deleted with the Id :" + employeeId;

    }
}
