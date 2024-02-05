package com.dcb.dcb.controller;

import com.dcb.dcb.model.Employee;
import com.dcb.dcb.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v2/employees")
public class EmployeeV2Controller {

    @PostMapping
    public Employee save(@RequestBody Employee employee) {
        return employee;
    }

}
