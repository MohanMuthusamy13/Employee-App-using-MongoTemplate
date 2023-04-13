package com.mojicode.mongo.mongoTemplate.dto;

import com.mojicode.mongo.mongoTemplate.model.Address;
import com.mojicode.mongo.mongoTemplate.model.Employee;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@Accessors(chain = true)
public class EmployeeRequest {
    private String firstName;
    private String lastName;
    private float salary;
    private Address address;

    public static Employee fromEmployeeRequest(EmployeeRequest employeeRequest) {
        return new Employee()
                .setFirstName(employeeRequest.getFirstName())
                .setLastName(employeeRequest.getLastName())
                .setSalary(employeeRequest.getSalary())
                .setAddress(employeeRequest.getAddress())
                .setJoiningDate(new Date());
    }
}