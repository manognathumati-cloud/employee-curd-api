package com.example.employee_crud_api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    // 🔹 GET ALL EMPLOYEES
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // 🔹 ADD NEW EMPLOYEE
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    // 🔹 UPDATE EMPLOYEE
    public Employee updateEmployee(Long id, Employee employee) {
        Employee existing = employeeRepository.findById(id).orElse(null);

        if (existing != null) {
            existing.setName(employee.getName());
            existing.setDepartment(employee.getDepartment());
            return employeeRepository.save(existing);
        }

        return null;
    }

    // 🔹 DELETE EMPLOYEE
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}