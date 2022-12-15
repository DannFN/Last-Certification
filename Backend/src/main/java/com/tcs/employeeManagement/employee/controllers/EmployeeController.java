package com.tcs.employeeManagement.employee.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.employeeManagement.employee.models.Employee;
import com.tcs.employeeManagement.employee.models.EmployeeRequestDTO;
import com.tcs.employeeManagement.employee.services.EmployeeService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(value = "/employees", 
            produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> getEmployees(@RequestParam(name = "dept", required = false) String dept,
                                    @RequestParam(name = "salary", required = false) String salary) {
        return employeeService.getEmployees(dept, salary);
    }

    @PostMapping(value = "/employees")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Employee> createEmployee(@Valid @RequestBody EmployeeRequestDTO employeeRequest) {
        return new ResponseEntity<>(employeeService.savEmployee(employeeRequest), HttpStatus.CREATED);
    }

    @PutMapping(value = "/employees/", 
        consumes = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Employee> updateEmployee(
            @RequestParam(name = "id", required = true) int id, @Valid @RequestBody EmployeeRequestDTO employeeRequest) {
        return new ResponseEntity<>(employeeService.updateEmployee(id, employeeRequest), HttpStatus.OK);
    }

    @DeleteMapping(value = "/employee/")
    @ResponseStatus(HttpStatus.OK)
    public void deleteEmployee(@RequestParam(name = "id", required = true) int id) {
        employeeService.deleteEmployee(id);
    }
}