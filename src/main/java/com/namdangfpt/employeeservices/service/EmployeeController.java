package com.namdangfpt.employeeservices.service;

import com.namdangfpt.employeeservices.exception_handler.EmployeeNotFound;
import com.namdangfpt.employeeservices.model.Employee;
import com.namdangfpt.employeeservices.model.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeDao service;

    @GetMapping(path = "/employees")
    public List<Employee> getAll() {
        return service.getAllEmployee();
    }

    @GetMapping(path = "/employees/{empId}")
    public Employee getEmployeeById(@PathVariable int empId) {
        Employee employee = service.getEmployeeById(empId);
        if (employee == null) throw new EmployeeNotFound("Employee Not Found");
        return employee;
    }

    @PostMapping(path = "/employees/user")
    public ResponseEntity<Object> saveEmployee(@RequestBody Employee emp) {
        Employee employee = service.saveEmployee(emp);
        URI uri =  ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{employeeId}")
                .buildAndExpand(employee.getEmployeeId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping(path = "/employees/delete/{empId}")
    public void deleteEmployees(@PathVariable int empId){
        Employee emp = service.deleteEmployee(empId);
        if (emp == null){
            throw new EmployeeNotFound("Employee not found");
        }
    }
}
