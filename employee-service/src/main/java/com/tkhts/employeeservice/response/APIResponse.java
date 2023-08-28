package com.tkhts.employeeservice.response;

import com.tkhts.employeeservice.entity.Employee;

import lombok.Data;

@Data
public class APIResponse{
    private Employee employee;
    private Department department;
}
