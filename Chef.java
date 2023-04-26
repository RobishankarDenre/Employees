package com.denre.employees;

public interface Chef {

    String fevFood = "Pizza";

    default String food(String food) {
        return String.format("Hii now i am cook %s..!!", food(food));
    }

    default void cleanUp() {
        System.out.println("Now i am clean Up...!!");
    }

    //    String yellAtPeople();
    default void setFevFood() {
        System.out.println(fevFood);
    }

    default String getFevFood() {
        return fevFood;
    }
}
