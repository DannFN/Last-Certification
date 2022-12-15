package com.tcs.employeeManagement.employee.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tcs.employeeManagement.employee.models.Employee;
import com.tcs.employeeManagement.employee.models.EmployeeRequestDTO;
import com.tcs.employeeManagement.employee.models.EmployeeUpdateRequestDTO;
import com.tcs.employeeManagement.employee.repositories.EmployeeRepository;

@Service
public class EmployeeService {
    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getEmployees(String dept, String salary) {
        List<Employee> employees = employeeRepository.findAll();

        if (dept != null) {
            employees.removeIf(employee -> !employee.getDepartment().equals(dept));
        }

        if (salary != null) {
            if (salary.equals("asc")) {
                employees.sort((e1, e2) -> e1.getSalary() - e2.getSalary());
            } else if (salary.equals("desc")) {
                employees.sort((e1, e2) -> e2.getSalary() - e1.getSalary());
            }
        }

        return employees;
    }

    public Employee savEmployee(EmployeeRequestDTO employeeRequest) {
        return employeeRepository.save(
                Employee.builder()
                        .id(employeeRequest.getId())
                        .firstName(employeeRequest.getFirstName())
                        .lastName(employeeRequest.getLastName())
                        .department(employeeRequest.getDepartment())
                        .salary(employeeRequest.getSalary())
                        .build());
    }

    public Employee updateEmployee(int id, EmployeeUpdateRequestDTO employeeUpdateRequest) {
        Employee employeeToUpdate = employeeRepository.findById(id).get();

        employeeToUpdate
                .setFirstName(employeeUpdateRequest.getFirstName() != null ? employeeUpdateRequest.getFirstName()
                        : employeeToUpdate.getFirstName());
        employeeToUpdate.setLastName(employeeUpdateRequest.getLastName() != null ? employeeUpdateRequest.getLastName()
                : employeeToUpdate.getLastName());
        employeeToUpdate
                .setDepartment(employeeUpdateRequest.getDepartment() != null ? employeeUpdateRequest.getDepartment()
                        : employeeToUpdate.getDepartment());
        employeeToUpdate
                .setSalary(employeeUpdateRequest.getSalary() >= 15000 && employeeUpdateRequest.getSalary() != null
                        ? employeeUpdateRequest.getSalary()
                        : employeeToUpdate.getSalary());

        return employeeRepository.save(employeeToUpdate);
    }

    public void deleteEmployee(int id) {
        employeeRepository.deleteById(id);
    }
}
