package com.mojicode.mongo.mongoTemplate.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Document(collection = "employee")
public class Employee {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private float salary;
    private Address address;
    private Date joiningDate;
}