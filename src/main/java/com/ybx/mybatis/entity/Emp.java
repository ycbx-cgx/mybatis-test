package com.ybx.mybatis.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Emp {
    private Integer id;
    private String name;
    private Integer deptId;
}
