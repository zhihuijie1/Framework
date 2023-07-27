package com.cgj.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.crypto.dom.DOMCryptoContext;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Emp {
    private int id;
    private String name;
    private Double math;
    private Double chinese;
    private Double english;
}
