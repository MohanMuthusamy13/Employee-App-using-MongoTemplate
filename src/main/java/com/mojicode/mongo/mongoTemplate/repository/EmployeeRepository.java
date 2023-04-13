package com.mojicode.mongo.mongoTemplate.repository;

import com.mojicode.mongo.mongoTemplate.dto.EmployeeRequest;
import com.mojicode.mongo.mongoTemplate.dto.EmployeeResponse;
import com.mojicode.mongo.mongoTemplate.model.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.CriteriaDefinition;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeRepository {

    private final MongoTemplate mongoTemplate;

    public EmployeeRepository(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public Employee save(Employee employee) {
        return mongoTemplate.save(employee);
    }

    public List<Employee> getEmployees() {
        return mongoTemplate.findAll(Employee.class);
    }

    public Employee getEmployeeById(String id) {
        return mongoTemplate.findById(id, Employee.class);
    }

    public List<Employee> getEmployeesLessThanSalary(float salary) {

        // MONGODB QUERY
        CriteriaDefinition criteria = new Criteria().where("salary").lte(salary);
        Query query = new Query(criteria);

        // PROJECTION
        query.fields().exclude("salary");
        return mongoTemplate.find(query, Employee.class);
    }

    public List<Employee> getEmployeesStartingWith(String employeeNamePrefix) {
        Query query = new Query(Criteria.where("firstName").regex("^" + employeeNamePrefix));
        return mongoTemplate.find(query, Employee.class);
    }
}