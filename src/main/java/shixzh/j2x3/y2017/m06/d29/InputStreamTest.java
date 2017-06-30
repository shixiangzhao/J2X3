package shixzh.j2x3.y2017.m06.d29;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

public class InputStreamTest {

    public static void main(String[] args) throws IOException {
        InputStream input = new BufferedInputStream(System.in);
        int bytesAvailable = 0;
        try {
            bytesAvailable = input.available();
            if (bytesAvailable > 0) {
                byte[] data = new byte[bytesAvailable];
                input.read(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            input.close();
        }
    }
}
