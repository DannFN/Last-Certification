package com.tcs.employeemanagement.employee.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "employees")
public class Employee {
    @Id
    private Integer id;
    private String firstName;
    private String lastName;
    private String department;
    private Integer salary;
}
