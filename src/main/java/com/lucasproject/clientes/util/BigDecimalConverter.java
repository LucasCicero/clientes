package com.lucasproject.clientes.util;

import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;


public class BigDecimalConverter {
    //1.000,00 -> big decimal 1000.00
    public BigDecimal converter(String value){

        if(value==null){
            return null;
        }

        value = value.replace(".","").replace(",",".");// remove . e substui , por .
        return new BigDecimal(value);
    }
}
