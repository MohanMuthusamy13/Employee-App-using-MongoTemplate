package com.mojicode.mongo.mongoTemplate.dto;

import com.mojicode.mongo.mongoTemplate.model.Address;
import com.mojicode.mongo.mongoTemplate.model.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@Accessors(chain = true)
public class EmployeeResponse {
    private String id;
    private String firstName;
    private String lastName;
    private Address address;
    private Date joiningDate;

    public static EmployeeResponse fromEmployee(Employee employee) {
        return new EmployeeResponse()
                .setId(employee.getId())
                .setFirstName(employee.getFirstName())
                .setLastName(employee.getLastName())
                .setAddress(employee.getAddress())
                .setJoiningDate(employee.getJoiningDate());
    }
}