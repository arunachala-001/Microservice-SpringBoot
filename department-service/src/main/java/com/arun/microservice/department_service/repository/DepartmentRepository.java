package com.arun.microservice.department_service.repository;

import com.arun.microservice.department_service.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
