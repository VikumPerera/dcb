package com.dcb.dcb.service;

import com.dcb.dcb.entity.Employee;
import com.dcb.dcb.model.EmployeeDTO;
import com.dcb.dcb.repository.EmployeeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

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
        return null;
    }

    @Override
    public EmployeeDTO getEmployeeById(String employeeId) {
        return null;
    }

    @Override
    public String deleteEmployee(String employeeId) {
        return null;
    }
}
