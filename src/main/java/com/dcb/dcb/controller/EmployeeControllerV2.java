package com.dcb.dcb.controller;

import com.dcb.dcb.model.EmployeeDTO;
import com.dcb.dcb.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

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

}
