package com.tcs.employeeManagement.employee.models;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmployeeRequestDTO {
    @NotBlank(message = "Invalid First Name: Empty name")
    @NotNull(message = "Invalid First Name: Name is NULL")
    @Size(min = 3, message = "Invalid First Name: Should have atleast 3 characters")
    String firstName;
    
    @NotBlank(message = "Invalid Last Name: Empty name")
    @NotNull(message = "Invalid Last Name: Name is NULL")
    @Size(min = 3, message = "Invalid Last Name: Should have atleast 3 characters")
    String lastName;
    
    @NotBlank(message = "Invalid Departament: Empty departament")
    @NotNull(message = "Invalid Departament: Departament is NULL")
    String department;
    
    @Min(value = 15000, message = "Invalid Salary: should be greater than 15000")
    @Max(value = 200000, message = "Invalid Salary: should be less than 200000")
    Integer salary;
}
