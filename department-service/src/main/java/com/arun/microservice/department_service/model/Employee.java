package com.arun.microservice.department_service.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Employee {
    private long id;
    private long departmentId;
    private String name;
    private long age;
    private String position;

//    @ManyToOne
//    @JoinColumn(name="department_id")
//    @JsonIgnore
//    private Department department;
}
