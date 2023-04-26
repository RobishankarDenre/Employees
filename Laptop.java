package com.denre.employees;

import java.time.LocalDate;

public class Laptop {
    public static void main(String[] args) {
        Dell d1 = new Dell("Roy", "James", LocalDate.of(2021,5,8), 35000.0);
//        HP hp1 = new HP("Smith", "John", LocalDate.of(2021, 12, 1), 68000.00);
        Dell d2 = new Dell("Paul","Rani");
        System.out.println(d1);
//        System.out.println(hp1);
        System.out.println(d1.sayHello());
    }
}
