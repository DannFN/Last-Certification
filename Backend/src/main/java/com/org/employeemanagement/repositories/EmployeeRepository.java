package com.org.employeemanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.employeemanagement.models.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}