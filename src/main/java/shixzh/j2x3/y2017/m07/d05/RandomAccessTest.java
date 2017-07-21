package shixzh.j2x3.y2017.m07.d05;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

import shixzh.j2x3.y2017.m06.d19.Employee;

public class RandomAccessTest {

    public static void main(String[] args) throws IOException {
        Employee[] staff = new Employee[3];
        staff[0] = new Employee("Carl Cracker1", 750001, 1987, 12, 15);
        staff[1] = new Employee("Carl Cracker2", 750002, 1988, 11, 14);
        staff[2] = new Employee("Carl Cracker3", 750003, 1989, 10, 13);

        String file = System.getProperty("user.dir") + File.separator + "employee.dat";
        try (DataOutputStream out = new DataOutputStream(new FileOutputStream(file))) {
            // save all employee records to the file employee.dat
            for (Employee e : staff) {
                writeData(out, e);
            }
        }

        try (RandomAccessFile in = new RandomAccessFile(file, "r")) {
            // retrieve all records into a new array

            // compute the array size
            int n = (int) (in.length() / Employee.RECORD_SIZE);
            Employee[] newStaff = new Employee[n];

            // read employees in reverse order
            for (int i = n - 1; i >= 0; i--) {
                newStaff[i] = new Employee();
                in.seek(i * Employee.RECORD_SIZE);
                newStaff[i] = readData(in);
            }

            // print the newly read employee records
            for (Employee e : newStaff) {
                System.out.println(e);
            }
        }
    }

    private static Employee readData(RandomAccessFile in) {
        return null;
    }

    private static void writeData(DataOutputStream out, Employee e) throws IOException {
        //DataIO.writeFixedString(e.getName(), Employee.NAME_SIZE, out);
        out.writeDouble(e.getSalary());

    }

}
