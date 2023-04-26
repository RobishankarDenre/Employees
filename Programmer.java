package com.denre.employees;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Programmer extends Employee implements IEmployee,Apple,Chef{
//    private final String role = "Programmer";

    private Double linesOfCode = 0.0;
    private Double yearsOfExp = 0.0;
    private int iq = 0;

    private final String proRegex = "\\w+\\s?=\\s?(?<locpd>\\w+),\\w+\\s?=\\s?(?<yoe>\\w+),\\w+\\s?=\\s?(?<iq>\\w+)";
    private final Pattern proPat = Pattern.compile(proRegex);

    public Programmer(String personsText) {
        super(personsText);
        Matcher proMat = proPat.matcher(peopleMat.group("details"));
        if (proMat.find()) {
            this.linesOfCode = Double.parseDouble(proMat.group("locpd"));
            this.yearsOfExp = Double.parseDouble(proMat.group("yoe"));
            this.iq = Integer.parseInt(proMat.group("iq"));
        }
    }

    public Double getSalary() {
        return 3000 + linesOfCode * yearsOfExp * iq;
    }

    public Programmer(String personsText, Double linesOfCode, Double yearsOfExp, int iq) {
        super(personsText);
        this.linesOfCode = linesOfCode;
        this.yearsOfExp = yearsOfExp;
        this.iq = iq;
    }

    public Double getLinesOfCode() {
        return linesOfCode;
    }

    public void setLinesOfCode(Double linesOfCode) {
        this.linesOfCode = linesOfCode;
    }

    public Double getYearsOfExp() {
        return yearsOfExp;
    }

    public void setYearsOfExp(Double yearsOfExp) {
        this.yearsOfExp = yearsOfExp;
    }

    public int getIq() {
        return iq;
    }

    public void setIq(int iq) {
        this.iq = iq;
    }
}
