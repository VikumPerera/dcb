package com.dcb.dcb.service;

import com.dcb.dcb.entity.Employee;
import com.dcb.dcb.exception.EmployeeNotFoundException;
import com.dcb.dcb.model.EmployeeDTO;
import com.dcb.dcb.repository.EmployeeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImplV2 implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDTO save(EmployeeDTO employeeDTO) {
        if (employeeDTO.getEmployeeId() == null) {
            employeeDTO.setEmployeeId(UUID.randomUUID().toString());
        }
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDTO, employee);
        employeeRepository.save(employee);
        return employeeDTO;
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        return employeeRepository.findAll()
                .stream()
                .map(employee -> {
                    EmployeeDTO employeeDTO = new EmployeeDTO();
                    BeanUtils.copyProperties(employee, employeeDTO);
                    return employeeDTO;
                })
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDTO getEmployeeById(String employeeId) {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(() ->
                new EmployeeNotFoundException("Employee not found with employeeId: " + employeeId));
        BeanUtils.copyProperties(employee, employeeDTO);
        return employeeDTO;
    }

    @Override
    public String deleteEmployee(String employeeId) {
        if (employeeRepository.existsById(employeeId)) {
            employeeRepository.deleteById(employeeId);
            return "Employee deleted with the Id :" + employeeId;
        } else {
            throw new EmployeeNotFoundException("Employee not found with employeeId: " + employeeId);
        }
    }
}
