package com.denre.employees;

import java.time.LocalDate;
import java.util.Objects;

public class Weirdo {
    private String lstName;
    private String firstName;
    private LocalDate dob;

    public Weirdo() {
    }

    public Weirdo(String lstName, String firstName, LocalDate dob) {
        this.lstName = lstName;
        this.firstName = firstName;
        this.dob = dob;
    }

    public String getLstName() {
        return lstName;
    }

    public void setLstName(String lstName) {
        this.lstName = lstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Weirdo weirdo = (Weirdo) o;
        return Objects.equals(lstName, weirdo.lstName) && Objects.equals(firstName, weirdo.firstName) && Objects.equals(dob, weirdo.dob);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lstName, firstName, dob);
    }
}
