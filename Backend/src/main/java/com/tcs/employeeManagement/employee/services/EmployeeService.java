package com.tcs.employeeManagement.employee.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tcs.employeeManagement.employee.models.Employee;
import com.tcs.employeeManagement.employee.models.EmployeeRequestDTO;
import com.tcs.employeeManagement.employee.repositories.EmployeeRepository;

@Service
public class EmployeeService {
    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getEmployees(String dept, String salary) {
        if (dept != null) {
            return employeeRepository.findByDepartment(dept);
        } else if (salary != null) {
            if (salary.equals("asc")) {
                return employeeRepository.findAllByOrderBySalaryAsc();
            } else if (salary.equals("desc")) {
                return employeeRepository.findAllByOrderBySalaryDesc();
            }
        }

        return employeeRepository.findAll();
    }

    public Employee savEmployee(EmployeeRequestDTO employeeRequest) {
        return employeeRepository.save(
                Employee.builder()
                        .firstName(employeeRequest.getFirstName())
                        .lastName(employeeRequest.getLastName())
                        .department(employeeRequest.getDepartment())
                        .salary(employeeRequest.getSalary())
                        .build());
    }

    public Employee updateEmployee(int id, EmployeeRequestDTO employeeRequest) {
        Employee employee = employeeRepository.findById(id).get();
        employee.setFirstName(employeeRequest.getFirstName());
        employee.setLastName(employeeRequest.getLastName());
        employee.setDepartment(employeeRequest.getDepartment());
        employee.setSalary(employeeRequest.getSalary());

        return employeeRepository.save(employee);
    }

    public void deleteEmployee(int id) {
        employeeRepository.deleteById(id);
    }
}
