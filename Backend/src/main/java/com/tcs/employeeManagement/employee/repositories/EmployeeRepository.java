package com.tcs.employeemanagement.employee.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcs.employeemanagement.employee.models.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}