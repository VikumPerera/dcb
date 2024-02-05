package com.dcb.dcb.service;

import com.dcb.dcb.exception.EmployeeNotFoundException;
import com.dcb.dcb.model.EmployeeDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    List<EmployeeDTO> employeeDTOList = new ArrayList<>();
    @Override
    public EmployeeDTO save(EmployeeDTO employeeDTO) {
        if (employeeDTO.getEmployeeId() == null) {
            employeeDTO.setEmployeeId(UUID.randomUUID().toString());
        }
        employeeDTOList.add(employeeDTO);
        return employeeDTO;
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        return employeeDTOList;
    }

    @Override
    public EmployeeDTO getEmployeeById(String employeeId) {
        return employeeDTOList
                .stream()
                .filter(employee -> employee.getEmployeeId().equals(employeeId))
                .findFirst()
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found with employeeId: " + employeeId));
    }

    @Override
    public String deleteEmployee(String employeeId) {
        EmployeeDTO employeeDTO = employeeDTOList
                .stream()
                .filter(e -> e.getEmployeeId().equals(employeeId))
                .findFirst()
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found with employeeId: " + employeeId));
        employeeDTOList.remove(employeeDTO);
        return "Employee deleted with the Id :" + employeeId;
    }
}
