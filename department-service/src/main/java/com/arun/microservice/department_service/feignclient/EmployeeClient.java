package com.arun.microservice.department_service.feignclient;

import com.arun.microservice.department_service.model.Employee;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "employee-service")
public interface EmployeeClient {

    @GetMapping("/employee/{departmentId}")
    List<Employee> getEmployeeById(@PathVariable long departmentId);
}
