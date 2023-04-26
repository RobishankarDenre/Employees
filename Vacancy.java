package com.denre.employees;

public class Vacancy extends Employee implements IEmployee,Apple{
    public Vacancy(String personsText) {
        super(personsText);
    }
    @Override
    public Double getSalary() {
        return 5000.0;
    }
}
