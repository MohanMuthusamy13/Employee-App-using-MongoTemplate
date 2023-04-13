package com.mojicode.mongo.mongoTemplate.service;

import com.mojicode.mongo.mongoTemplate.dto.EmployeeRequest;
import com.mojicode.mongo.mongoTemplate.dto.EmployeeResponse;
import com.mojicode.mongo.mongoTemplate.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {
    List<EmployeeResponse> getEmployees();
    EmployeeResponse getEmployeeById(String employeeId);
    EmployeeResponse saveEmployee(EmployeeRequest employee);
    List<EmployeeResponse> getEmployeesLessThanSalary(float salary);
    List<EmployeeResponse> getEmployeesStartingWith(String employeeNamePrefix);
}