package com.mojicode.mongo.mongoTemplate.service;

import com.mojicode.mongo.mongoTemplate.dto.EmployeeRequest;
import com.mojicode.mongo.mongoTemplate.dto.EmployeeResponse;
import com.mojicode.mongo.mongoTemplate.model.Employee;
import com.mojicode.mongo.mongoTemplate.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService{

    private final EmployeeRepository employeeRepository;

    @Override
    public List<EmployeeResponse> getEmployees() {
        return employeeRepository.getEmployees().stream()
                .map(EmployeeResponse::fromEmployee)
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeResponse getEmployeeById(String employeeId) {
        return EmployeeResponse.fromEmployee(employeeRepository.getEmployeeById(employeeId));
    }

    @Override
    public EmployeeResponse saveEmployee(EmployeeRequest employeeRequest) {
        Employee employee = EmployeeRequest.fromEmployeeRequest(employeeRequest);
        return EmployeeResponse.fromEmployee(employeeRepository.save(employee));
    }

    @Override
    public List<EmployeeResponse> getEmployeesLessThanSalary(float salary) {
        return employeeRepository.getEmployeesLessThanSalary(salary).stream()
                .map(EmployeeResponse::fromEmployee)
                .collect(Collectors.toList());
    }

    @Override
    public List<EmployeeResponse> getEmployeesStartingWith(String employeeNamePrefix) {
        return employeeRepository.getEmployeesStartingWith(employeeNamePrefix)
                .stream().map(EmployeeResponse::fromEmployee)
                .collect(Collectors.toList());
    }
}