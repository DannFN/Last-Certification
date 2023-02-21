package com.tcs.employeemanagement.employee.models;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmployeeRequestDTO {
    @NotNull(message = "Invalid ID: ID is NULL")
    @Min(value = 1, message = "Invalid ID: ID should be greater than 0")
    int id;

    @NotBlank(message = "Invalid First Name: Empty name")
    @NotNull(message = "Invalid First Name: Name is NULL")
    @Size(min = 3, message = "Invalid First Name: Should have at least 3 characters")
    @Pattern(regexp = "^[A-Za-z]*$", message = "Invalid First Name: Should not have special characters")
    String firstName;

    @NotBlank(message = "Invalid Last Name: Empty name")
    @NotNull(message = "Invalid Last Name: Name is NULL")
    @Size(min = 3, message = "Invalid Last Name: Should have at least 3 characters")
    @Pattern(regexp = "^[A-Za-z]*$", message = "Invalid Last Name: Should not have special characters")
    String lastName;

    @NotBlank(message = "Invalid Departament: Empty departament")
    @NotNull(message = "Invalid Departament: Departament is NULL")
    String department;

    @NotNull(message = "Invalid Saralry: Salary is NULL")
    @Min(value = 15000, message = "Invalid Salary: should be greater than 15000")
    @Max(value = 200000, message = "Invalid Salary: should be less than 200000")
    Integer salary;
}
