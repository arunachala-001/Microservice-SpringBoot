package com.arun.microservice.employee_service.controller;

import com.arun.microservice.employee_service.model.Employee;
import com.arun.microservice.employee_service.repository.EmployeeRespository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {

    @Autowired
    private EmployeeRespository employeeRespository;

    @PostMapping("/store")
    public ResponseEntity<String> saveEmployee(@RequestBody Employee employee) {
        try{
            employeeRespository.save(employee);
            return ResponseEntity.ok().body("Employee Added Succssfully");
        }
        catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{departmentId}")
    public List<Employee> getEmployeeListByJobId(@PathVariable long departmentId) {
        return employeeRespository.findByDepartmentId(departmentId);
    }
}
