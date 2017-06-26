package shixzh.j2x3.y2017.m06.d19;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class TextFileTest {

    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        String temp = System.getProperty("user.dir") + "\\employee.dat";
        System.out.println(temp);
        Employee[] staff = new Employee[3];
        staff[0] = new Employee("Carl Cracker", 75000, 1987, 12, 15);
        staff[1] = new Employee("Hrary Harker", 55000, 1989, 10, 13);
        staff[2] = new Employee("Tony Tester", 45000, 1988, 11, 12);

        try (PrintWriter out = new PrintWriter(temp, "UTF-8")) {
            writeData(staff, out);
        }

        try (Scanner in = new Scanner(new FileInputStream(temp), "UTF-8")) {
            Employee[] newStaff = readData(in);
            for (Employee e : newStaff) {
                System.out.println(e);
            }
        }
    }

    private static Employee[] readData(Scanner in) {
        int n = in.nextInt();
        in.nextLine();

        Employee[] employees = new Employee[n];
        for (int i = 0; i < n; i++) {
            employees[i] = readEmployee(in);
        }
        return employees;
    }

    private static Employee readEmployee(Scanner in) {
        String line = in.nextLine();
        String[] tokens = line.split("\\|");
        String name = tokens[0];
        double salary = Double.parseDouble(tokens[1]);
        int year = Integer.parseInt(tokens[2]);
        int month = Integer.parseInt(tokens[3]);
        int day = Integer.parseInt(tokens[4]);
        return new Employee(name, salary, year, month, day);
    }

    private static void writeData(Employee[] employees, PrintWriter out) {
        out.println(employees.length);
        for (Employee e : employees) {
            writeEmployee(out, e);
        }

    }

    private static void writeEmployee(PrintWriter out, Employee e) {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(e.getHireDate());
        out.println(e.getName() + "|" + e.getSalary() + "|" + calendar.get(Calendar.YEAR) + "|"
                + (calendar.get(Calendar.MONDAY) + 1) + "|" + calendar.get(Calendar.DAY_OF_MONTH));

    }

}
