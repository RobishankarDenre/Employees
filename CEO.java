package com.denre.employees;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CEO extends Employee implements IEmployee, Apple, Flyer {
    private Flyer flyer = new Pilot(12000, true);
    private double avgStockPrice = 0.0;
    private final String ceoRegex = "\\w+\\s?=\\s?(?<avgStkPrice>\\w+)";
    private final Pattern ceoPat = Pattern.compile(ceoRegex);

    public CEO(String personsText) {
        super(personsText);
        Matcher ceoMat = ceoPat.matcher(peopleMat.group("details"));
        if (ceoMat.find()) {
            this.avgStockPrice = Double.parseDouble(ceoMat.group("avgStkPrice"));
        }
    }

    public Double getSalary() {
//        salary = 5500 * avgStockPrice;
        return 5500 * avgStockPrice;
    }

    public void fly() {
        flyer.fly();
    }

    public int getHoursFlown() {
        return flyer.getHoursFlown();
    }

    public void setHoursFlown(int hoursFlown) {
        flyer.setHoursFlown(hoursFlown);
    }

    public boolean isIfr() {
        return flyer.isIfr();
    }

    public void setIfr(boolean ifr) {
        flyer.setIfr(ifr);
    }

    public CEO(String personsText, Flyer flyer, double avgStockPrice) {
        super(personsText);
        this.flyer = flyer;
        this.avgStockPrice = avgStockPrice;
    }

    public Flyer getFlyer() {
        return flyer;
    }

    public void setFlyer(Flyer flyer) {
        this.flyer = flyer;
    }

    public double getAvgStockPrice() {
        return avgStockPrice;
    }

    public void setAvgStockPrice(double avgStockPrice) {
        this.avgStockPrice = avgStockPrice;
    }

    public String getCeoRegex() {
        return ceoRegex;
    }

    public Pattern getCeoPat() {
        return ceoPat;
    }
}
