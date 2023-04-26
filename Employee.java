package com.denre.employees;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Employee implements IEmployee {

    private static final String PEOPLE_REGEX = "(?<lnm>\\w+),\\s(?<fnm>\\w+),\\s(?<dob>\\d{1,2}/\\d{1,2}/\\d{4}),\\s*(?<role>\\w+)(?:,\\s*\\{(?<details>.*)\\})?\\n";
    protected static final Pattern PEOPLE_PAT = Pattern.compile(PEOPLE_REGEX);
    protected String lastName;
    protected String firstName;
    protected LocalDate dob;
    protected String role;
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    protected final Matcher peopleMat;

    protected Employee(String personsText) {
        peopleMat = PEOPLE_PAT.matcher(personsText);
        if (peopleMat.find()) {
            this.lastName = peopleMat.group("lnm");
            this.firstName = peopleMat.group("fnm");
            this.dob = LocalDate.from(dateTimeFormatter.parse(peopleMat.group("dob")));
            this.role = peopleMat.group("role");

        }
    }

    //    Koli, Virat, 06/12/1991, Analyst, {ProjectCount = 7}
    public static final IEmployee createEmployee(String employeeText) {
        Matcher peopleMat = Employee.PEOPLE_PAT.matcher(employeeText);
        if (peopleMat.find()) {
            return switch (peopleMat.group("role")) {
                case "Programmer" -> new Programmer(employeeText);
                case "Manager" -> new Manager(employeeText);
                case "Analyst" -> new Analyst(employeeText);
                case "CEO" -> new CEO(employeeText);
                default -> new Vacancy(employeeText);
            };
        } else {
            return new Vacancy(employeeText);
        }
    }

    public abstract Double getSalary();


    public Double getBonus() {
        return getSalary() * 4.5;
    }

    @Override
    public String toString() {
        Double salary = getSalary();
        Double bonus = getBonus();
        return String.format("%s, %s,%s, %s %s", lastName, firstName, role, salary, bonus);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return lastName.equals(employee.lastName) && firstName.equals(employee.firstName) && dob.equals(employee.dob);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastName, firstName, dob);
    }

    @Override
    public int compareTo(IEmployee o) {
        Employee other = (Employee) o;
        return this.lastName.compareTo(other.lastName);
    }
}
