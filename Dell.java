package com.denre.employees;

import java.time.LocalDate;

public record Dell(String lastName, String firstName, LocalDate pd, Double price) {

    public Dell(String lastName, String firstName) {
        this(lastName, firstName,null,null);
    }
    protected String sayHello() {
        return "Hello World";
    }
}
