package com.denre.employees;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Manager extends Employee implements IEmployee,Apple{
    private int orgSize = 0;
    private int dr = 0;
    private final String managerRegex = "\\w+\\s?=\\s?(?<orgSize>\\w+),\\w+\\s?=\\s?(?<dr>\\w+)";
    private final Pattern managerPat = Pattern.compile(managerRegex);

    public Manager(String personsText) {
        super(personsText);
        Matcher mgrMat = managerPat.matcher(peopleMat.group("details"));
        if (mgrMat.find()) {
            this.orgSize = Integer.parseInt(mgrMat.group("orgSize"));
            this.dr = Integer.parseInt(mgrMat.group("dr"));
        }
    }
    public Double getSalary() {
        return 2500 + Math.pow(orgSize, 2) + dr;
    }

    public Manager(String personsText, int orgSize, int dr) {
        super(personsText);
        this.orgSize = orgSize;
        this.dr = dr;
    }

    public int getOrgSize() {
        return orgSize;
    }

    public void setOrgSize(int orgSize) {
        this.orgSize = orgSize;
    }

    public int getDr() {
        return dr;
    }

    public void setDr(int dr) {
        this.dr = dr;
    }

    public String getManagerRegex() {
        return managerRegex;
    }

    public Pattern getManagerPat() {
        return managerPat;
    }
}
