package com.tkhts.departmentservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Department {

    @Id
    private Long id;
    private String departmentName;
    private String departmentDescription;
    private String departmentCode;
}
