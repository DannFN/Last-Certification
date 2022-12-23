package com.tcs.employeeManagement.employee.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcs.employeeManagement.employee.models.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}