package shixzh.j2x3.y2017.m06.d26;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HrefMatch {

    public static void main(String[] args) {

        // get URL string from command line or use default
        String urlString;
        if (args.length > 0) {
            urlString = args[0];
        } else {
            urlString = "http://mirror.bit.edu.cn/web/";
        }

        // open reader for URL
        try {
            InputStreamReader in = new InputStreamReader(new URL(urlString).openStream());
            // read contents into string builder
            StringBuilder input = new StringBuilder();
            int ch;
            while ((ch = in.read()) != -1) {
                input.append((char) ch);
            }

            //search for all occurrences of pattern
            // \\s+:1-n个空格， \\s*:0-n个空格，():一个group，
            // [^\"]*：0-n个非"字符，[^\\s>]*:0-n个非空非>字符
            String patternString = "<a\\s+href\\s*=\\s*(\"[^\"]*\"|[^\\s>]*)\\s*>";
            Pattern pattern = Pattern.compile(patternString, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(input);

            while (matcher.find()) {
                int start = matcher.start();
                int end = matcher.end();
                String match = input.substring(start, end);
                System.out.println(match);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
