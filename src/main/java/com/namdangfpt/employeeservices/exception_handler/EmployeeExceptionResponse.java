package com.namdangfpt.employeeservices.exception_handler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
public class EmployeeExceptionResponse {
    private String errorMessage, description;
    private Date dateAndTime;
}
