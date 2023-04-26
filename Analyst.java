package com.denre.employees;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Analyst extends Employee implements IEmployee,Apple{
    private Double numbersOfProject;
    private final String analystRegex = "\\w+\\s?=\\s?(?<proCount>\\w+)";
    private final Pattern analystPat = Pattern.compile(analystRegex);

    public Analyst(String personsText) {
        super(personsText);
        Matcher anaMat = analystPat.matcher(peopleMat.group("details"));
        if (anaMat.find()) {
            this.numbersOfProject = Double.parseDouble(anaMat.group("proCount"));
        }
    }
    public Double getSalary() {
        return 2200 + 1 * Math.pow(numbersOfProject, numbersOfProject - 2);
//        2200 + 1  * Math.pow(numberOfProject, numberOfProject - 2)
    }

    public Analyst(String personsText, Double numbersOfProject) {
        super(personsText);
        this.numbersOfProject = numbersOfProject;
    }

    public Double getNumbersOfProject() {
        return numbersOfProject;
    }

    public void setNumbersOfProject(Double numbersOfProject) {
        this.numbersOfProject = numbersOfProject;
    }

    public String getAnalystRegex() {
        return analystRegex;
    }

    public Pattern getAnalystPat() {
        return analystPat;
    }
}
