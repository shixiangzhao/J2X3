package shixzh.j2x3.y2017.m06.d26;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {

    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner in = new Scanner(System.in);
        //System.out.println("Enter pattern: ");
        //String patternString = in.nextLine();

        // e.g. 11:59am
        // String patternString = "((1?[0-9]):([0-5][0-9]))[ap]m";
        String patternString = "\\w";
        Pattern pattern = Pattern.compile(patternString);

        while (true) {
            System.out.println("Enter string to match: ");

            String input = in.nextLine();
            if (input == null || input.equals(""))
                return;
            Matcher matcher = pattern.matcher(input);
            if (matcher.matches()) {
                System.out.println("Match");
                int g = matcher.groupCount();
                if (g > 0) {
                    for (int i = 0; i < input.length(); i++) {
                        for (int j = 1; j <= g; j++) {
                            if (i == matcher.start(j) && i == matcher.end(j)) {
                                System.out.print("()");
                            }
                        }
                        for (int j = 1; j <= g; j++) {
                            if (i == matcher.start(j) && i != matcher.end(j)) {
                                System.out.print("(");
                            }
                        }
                        for (int j = 1; j <= g; j++) {
                            if (i != matcher.start(j) && i == matcher.end(j)) {
                                System.out.print(")");
                            }
                        }
                    }
                    System.out.println();
                }
            } else {
                System.out.println("No match");
            }
        }
    }

}
