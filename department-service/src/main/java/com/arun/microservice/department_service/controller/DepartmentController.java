package com.arun.microservice.department_service.controller;

import com.arun.microservice.department_service.dto.DepartmentDTO;
import com.arun.microservice.department_service.feignclient.EmployeeClient;
import com.arun.microservice.department_service.model.Department;
import com.arun.microservice.department_service.model.Employee;
import com.arun.microservice.department_service.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
@RequiredArgsConstructor
public class DepartmentController {

    @Autowired
    private DepartmentRepository departmentRepo;

    @Autowired
    private EmployeeClient employeeClient;

    @GetMapping("/get")
    public List<DepartmentDTO> getAllDepartments() {
        List<Department> departments = departmentRepo.findAll();

        return departments.stream()
                .map(dep -> mapToEmployee(dep))
                .toList();
    }

    private DepartmentDTO mapToEmployee(Department dep) {
        List<Employee> employees = employeeClient.getEmployeeById(dep.getId());
        DepartmentDTO departmentDTO = DepartmentDTO.builder()
                .id(dep.getId())
                .name(dep.getName())
                .employees(employees)
                .build();
        return departmentDTO;
    }

    @PostMapping("/store")
    public ResponseEntity<String> saveDepartments(@RequestBody Department department) {
        try{
            departmentRepo.save(department);
            return ResponseEntity.ok().body("Data Saved Successfully");
        }
        catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }
}
