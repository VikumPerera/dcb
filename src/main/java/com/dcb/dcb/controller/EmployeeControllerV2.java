package com.dcb.dcb.controller;

import com.dcb.dcb.model.EmployeeDTO;
import com.dcb.dcb.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v2/employees")
public class EmployeeControllerV2 {

    @Qualifier("employeeServiceImplV2")
    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public EmployeeDTO save(@RequestBody EmployeeDTO employeeDTO) {
        return employeeService.save(employeeDTO);
    }

    @GetMapping
    public List<EmployeeDTO> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{employeeId}")
    public EmployeeDTO getEmployeeById(@PathVariable String employeeId) {
        return employeeService.getEmployeeById(employeeId);
    }

    @DeleteMapping("/{employeeId}")
    public String deleteEmployee(@PathVariable String employeeId) {
        return employeeService.deleteEmployee(employeeId);
    }

}
