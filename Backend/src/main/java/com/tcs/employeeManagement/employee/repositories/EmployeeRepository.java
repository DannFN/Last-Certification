package com.tcs.employeeManagement.employee.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcs.employeeManagement.employee.models.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    List<Employee> findByDepartment(String dept);

    List<Employee> findAllByOrderBySalaryAsc();

    List<Employee> findAllByOrderBySalaryDesc();
}