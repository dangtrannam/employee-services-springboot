package com.namdangfpt.employeeservices.model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class EmployeeDao {
    static List<Employee> list = new ArrayList<>();

    static {
        list.add(new Employee(1, "Nancy", "nancy@mail.com"));
        list.add(new Employee(2, "Daniel", "daniel@mail.com"));
        list.add(new Employee(3, "Scott", "scott@mail.com"));
    }

    public List<Employee> getAllEmployee() {
        return list;
    }

    public Employee getEmployeeById(int empId) {
        return list.stream()
                .filter(emp -> emp.getEmployeeId() == empId)
                .findAny()
                .orElse(null);
    }
    public Employee saveEmployee(Employee emp){
        emp.setEmployeeId(list.size()+1);

        list.add(emp);
        return emp;
    }
    public Employee deleteEmployee (int empId){
        Iterator<Employee> iterator = list.iterator();
        while(iterator.hasNext()){
            Employee emp = iterator.next();
            if (empId == emp.getEmployeeId()){
                iterator.remove();
                return emp;
            }
        }
        return null;
    }
}
