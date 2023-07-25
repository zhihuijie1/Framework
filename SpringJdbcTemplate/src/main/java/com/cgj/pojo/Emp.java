package com.cgj.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor //自动生成包含这个类所有参数的构造函数，Lombok在编译的时候自动生成。使用这个注解，你不再需要手动编写这个构造函数
@NoArgsConstructor //它会自动生成一个无参构造函数。这对于一些框架和库在反射实例化对象时非常有用。
@Data //@Data 是 Lombok 提供的一个组合注解，它包含了 @Getter、@Setter、@ToString、@EqualsAndHashCode 和 @RequiredArgsConstructor 这几个注解。
//使用 @Data 注解可以一次性生成类的所有常用方法。这样就会在编译时生成 getter、setter、toString、equals 和 hashCode 方法。
public class Emp implements Serializable {
    private Double empno;
    private String ename;
    private String job;
    private Integer mgr;
    private Date hiredate;
    private Double sal;
    private Double comm;
    private Integer deptno;
}
