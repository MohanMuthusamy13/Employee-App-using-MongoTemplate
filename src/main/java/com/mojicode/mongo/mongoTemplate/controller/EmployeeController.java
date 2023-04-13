package com.mojicode.mongo.mongoTemplate.controller;

import com.mojicode.mongo.mongoTemplate.dto.EmployeeRequest;
import com.mojicode.mongo.mongoTemplate.dto.EmployeeResponse;
import com.mojicode.mongo.mongoTemplate.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping
    public List<EmployeeResponse> getEmployees() {
        return employeeService.getEmployees();
    }

    @GetMapping("/{id}")
    public EmployeeResponse getEmployeeById(@PathVariable(value = "id") String employeeId) {
        return employeeService.getEmployeeById(employeeId);
    }

    @PostMapping
    public EmployeeResponse addEmployee(
            @RequestBody EmployeeRequest employeeRequest
    ) {
        return employeeService.saveEmployee(employeeRequest);
    }

    @GetMapping("/get-employee-less-than/{salary}")
    public List<EmployeeResponse> getEmployeeLessThanSalary(
            @PathVariable(value = "salary") float salary) {
        return employeeService.getEmployeesLessThanSalary(salary);
    }

    @GetMapping("get-employees-starting-with/{prefixName}")
    public List<EmployeeResponse> getEmployeesStartingWith(
            @PathVariable(value = "prefixName") String prefixName) {
        return employeeService.getEmployeesStartingWith(prefixName);
    }
}