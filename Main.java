package com.denre.employees;

import java.util.*;
import java.util.regex.Matcher;

public class Main {

    public static void main(String[] args) {
        String frnd = """
                Smith, Stive, 05/08/1995, Programmer, {locpd = 2000,yoe = 5,iq = 140}
                Smith, Stive, 05/08/1995, Programmer, {locpd = 2000,yoe = 5,iq = 140}
                Smith, Stive, 05/08/1995, Programmer, {locpd = 2000,yoe = 5,iq = 140}
                Smith, Stive, 05/08/1995, Programmer, {locpd = 2000,yoe = 5,iq = 140}
                Smith, Stive, 05/08/1995, Programmer, {locpd = 2000,yoe = 5,iq = 140}
                Smith, Stive, 05/08/1995, Programmer, {locpd = 2000,yoe = 5,iq = 140}
                Smith, Stive, 05/08/1995, Programmer, {locpd = 2000,yoe = 5,iq = 140}
                Mearry, Stiven 22/06/1992, Table, {new Employee}
                Carrey, Stive, 09/12/1989, Programmer, {locpd = fff1200,yoe = 7,iq = 150}
                Smith2, Stive, 23/08/1993, Programmer, {locpd = 2200,yoe = 3,iq = 120}
                Smith3, Stive, 01/05/1998, Programmer, {locpd = 2400,yoe = 2,iq = 144}
                Sharma, Rohit, 11/11/1996, Manager, {orgSize = 200,dr = 10}
                Sharma1, Rohit, 18/03/1998, Manager, {orgSize = 250,dr = 5}
                Sharma2, Rohit, 12/11/1988, Manager, {orgSize = 400,dr = 9}
                Sharma3, Rohit, 01/10/1999, Manager, {orgSize = 900,dr = 7}
                Boab, David, 06/12/1991, Analyst, {ProjectCount = 7}
                Koli1, Virat, 28/09/1998, Analyst, {ProjectCount = 8}
                Koli2, Virat, 30/01/1990, Analyst, {ProjectCount = 9}
                Koli3, Virat, 25/07/1999, Analyst, {ProjectCount = 6}
                Allen, Finn, 29/11/1987, CEO, {avgStockPrice = 450}
                """;
        Matcher peopleMat = Employee.PEOPLE_PAT.matcher(frnd);

        Double totalSalaries = 0.0;
        IEmployee employee = null;

        Set<IEmployee> employees = new HashSet<>();
        while (peopleMat.find()) {
            employee = Employee.createEmployee(peopleMat.group());
            employees.add(employee);
        }
        System.out.println(employees.size());

        for (IEmployee worker : employees) {
            System.out.println(worker.toString());
            totalSalaries += employee.getSalary();
        }
        System.out.printf("The Total salaries %s%n", (totalSalaries));
    }


    private static void removeEmp(List<IEmployee> employees, List<String> removeEmployee) {
        for (Iterator<IEmployee> itr = employees.iterator(); itr.hasNext(); ) {
            IEmployee worker = itr.next();
            if (worker instanceof Employee tempWorker) {
                if (removeEmployee.contains(tempWorker.lastName)) {
                    itr.remove();
                }
            }
        }
    }
}