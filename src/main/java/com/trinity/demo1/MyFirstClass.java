package com.trinity.demo1;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

//@Component //Considera que esto es un posible bean 
public class MyFirstClass {

    private String myVar;

    public MyFirstClass(String myVar) {
        this.myVar = myVar;
    }

    public String sayHello() {
        return "Hello from class: My First Class ==> myVar = " + myVar;
    }

}
