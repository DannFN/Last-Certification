package com.tcs.employeemanagement.employee.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.employeemanagement.employee.models.Employee;
import com.tcs.employeemanagement.employee.models.EmployeeRequestDTO;
import com.tcs.employeemanagement.employee.models.EmployeeUpdateRequestDTO;
import com.tcs.employeemanagement.employee.services.EmployeeService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(value = "/employees", produces = { "application/json" })
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

    @PutMapping(value = "/employees/{id}", consumes = { "application/json" })
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Employee> updateEmployee(@PathVariable int id,
            @Valid @RequestBody EmployeeUpdateRequestDTO employeeUpdateRequest) {
        return new ResponseEntity<>(employeeService.updateEmployee(id, employeeUpdateRequest), HttpStatus.OK);
    }

    @DeleteMapping(value = "/employees/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteEmployee(@PathVariable int id) {
        employeeService.deleteEmployee(id);
    }
}