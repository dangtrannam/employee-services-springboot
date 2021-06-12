package com.namdangfpt.employeeservices.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Employee {
    private int employeeId;
    private String name;
    private String email;
}
