package com.tkhts.employeeservice.response;

import lombok.Data;

@Data
public class Department {
    private Long id;
    private String departmentName;
    private String departmentDescription;
    private String departmentCode;
}

