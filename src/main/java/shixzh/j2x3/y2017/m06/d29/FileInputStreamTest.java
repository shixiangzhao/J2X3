package shixzh.j2x3.y2017.m06.d29;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PushbackInputStream;

public class FileInputStreamTest {

    public static void main(String[] args) throws IOException {
        String userDir = System.getProperty("user.dir");
        String file = userDir + File.separator + "employee.dat";
        System.out.println(file);

        testFileInputStream(file);
        testDataInputStream2(file);
        testDataInputStream3(file);
        testPushbackInputStream(file);
    }

    public static void testFileInputStream(String file) throws IOException {
        FileInputStream input = new FileInputStream(file);
        int bytesAvailable = 0;
        try {
            bytesAvailable = input.available();
            if (bytesAvailable > 0) {
                byte[] data = new byte[bytesAvailable];
                input.read(data);
                printBytes(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            input.close();
        }
    }

    public static void testDataInputStream2(String file) throws IOException{
        FileInputStream fin = new FileInputStream(file);
        DataInputStream din = new DataInputStream(fin);
        double s = din.readDouble();
        System.out.println(s);
    }

    public static void testDataInputStream3(String file) throws IOException{
        DataInputStream din = new DataInputStream(
                new BufferedInputStream(
                        new FileInputStream(file)));
        double s = din.readDouble();
        System.out.println(s);
    }

    public static void testPushbackInputStream(String file) throws IOException {
        PushbackInputStream pin = new PushbackInputStream(
                new BufferedInputStream(
                        new FileInputStream(file)));
        int b = pin.read();
        System.out.print(b + " ");
        if(b != '<') {
            pin.unread(b);
        }
        b = pin.read();
        System.out.println(b);
    }
    private static void printBytes(byte[] bytes) {
        for (byte d : bytes) {
            System.out.print(String.valueOf(d) + " ");
        }
        System.out.println();
    }
}
