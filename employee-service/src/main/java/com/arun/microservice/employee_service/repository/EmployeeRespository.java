package com.arun.microservice.employee_service.repository;

import com.arun.microservice.employee_service.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRespository extends JpaRepository<Employee, Long> {

    List<Employee> findByDepartmentId(long departmentId);
}
