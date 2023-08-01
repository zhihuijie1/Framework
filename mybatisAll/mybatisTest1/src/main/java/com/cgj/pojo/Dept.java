package com.cgj.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Dept {
    private Integer deptno;
    private String dname;
    private String loc;
}
