package shixzh.j2x3.y2017.m07.d05;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathTest {

    public static void main(String[] args) {
        Path absolute = Paths.get("D:", "Cienet", "workspace", "J2X3", "employee.dat");
        System.out.println(absolute.toString());
        Path relative = Paths.get("conf", "user.properties");
        System.out.println(relative.toString());

    }

}
