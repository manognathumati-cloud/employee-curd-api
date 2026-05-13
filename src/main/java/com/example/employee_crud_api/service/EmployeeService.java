package com.example.employee_crud_api.service;

import com.example.employee_crud_api.dto.EmployeeDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeService.class);

    // Temporary list (instead of database)
    private List<EmployeeDTO> employeeList = new ArrayList<>();

    // ✅ GET all employees
    public List<EmployeeDTO> getAllEmployees() {
        logger.info("Getting all employees");
        return employeeList;
    }

    // ✅ GET employee by ID
    public EmployeeDTO getEmployeeById(Long id) {
        logger.info("Getting employee by ID: " + id);
        return employeeList.stream()
                .filter(emp -> emp.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    // ✅ CREATE employee
    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
        logger.info("Creating employee: " + employeeDTO.getName());
        employeeList.add(employeeDTO);
        return employeeDTO;
    }

    // ✅ UPDATE employee
    public EmployeeDTO updateEmployee(Long id, EmployeeDTO updatedEmployee) {
        logger.info("Updating employee with ID: " + id);

        for (EmployeeDTO emp : employeeList) {
            if (emp.getId().equals(id)) {
                emp.setName(updatedEmployee.getName());
                emp.setEmail(updatedEmployee.getEmail());
                emp.setDepartment(updatedEmployee.getDepartment());
                return emp;
            }
        }
        return null;
    }

    // ✅ DELETE employee
    public void deleteEmployee(Long id) {
        logger.warn("Deleting employee with ID: " + id);
        employeeList.removeIf(emp -> emp.getId().equals(id));
    }
}