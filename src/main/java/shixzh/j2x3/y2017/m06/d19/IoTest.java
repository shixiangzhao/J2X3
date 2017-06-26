package shixzh.j2x3.y2017.m06.d19;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class IoTest {

    public static void main(String[] args) {
        String userDir = System.getProperty("user.dir");
        System.out.println(userDir);
        try (FileInputStream fin = new FileInputStream(userDir + "/.gitignore");) {
            int inLength = fin.available();
            byte[] b = new byte[inLength];
            System.out.println(fin.read(b));
            for (byte by : b) {
                System.out.println(String.valueOf(by));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
