package com.dcb.dcb.service;

import com.dcb.dcb.model.EmployeeDTO;

import java.util.List;

public interface EmployeeService {

    EmployeeDTO save(EmployeeDTO employeeDTO);

    List<EmployeeDTO> getAllEmployees();

    EmployeeDTO getEmployeeById(String employeeId);

    String deleteEmployee(String employeeId);
}
