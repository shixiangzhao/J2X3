package shixzh.j2x3.y2017.m06.d26;

import java.util.regex.Pattern;

public class RegexTest1 {

    public static void main(String[] args) {
        String test = "a<tr>aava </tr>abb ";
        // X?、X*、X+、X{n} 是最大匹配（贪婪型）
        // 在 Greediness 的模式下，会尽量大范围的匹配，直到匹配了整个内容，
        // 这时发现匹配不能成功时，开始回退缩小匹配范围，直到匹配成功。
        String reg = "<.+>"; // <tr>aava </tr> 而不是 <tr> 或者</tr>
        System.out.println(test.replaceAll(reg, "###"));

        // X??、X*?、X+?、X{n}? 是最小匹配（勉强型）
        // 在 Greediness 模式之后添加 ? 就成最小匹配。
        // 在 Reluctant 的模式下，只要匹配成功，就不再继续尝试匹配更大范围的内容
        String reg1 = "<.+?>"; // <tr> </tr> 而不是 <tr>aava </tr>
        System.out.println(test.replaceAll(reg1, "###"));

        // X?+、X*+、X++、X{n}+ 是完全匹配（占有型）
        // 在 Greediness 模式之后添加 + 就成完全匹配。
        // Possessive 模式与 Greediness 有一定的相似性，那就是都尽量匹配最大范围的内容，直到内容结束，
        // 但与 Greediness 不同的是，完全匹配不再回退尝试匹配更小的范围。
        String reg2 = "<.++>"; // none
        System.out.println(test.replaceAll(reg2, "###"));

        String test1 = "<ttttt>";
        String reg3 = "<t++>"; // none
        System.out.println(test1.replaceAll(reg3, "###"));
        String test2 = "<.>";
        System.out.println(test2.replaceAll(reg2, "###"));

        String serialNumber = "\"serialNumber\":\"DF1234s\"";

        String patternStr = "\"serialNumber\":\"([a-zA-Z0-9]*)\"";
        Pattern pattern = Pattern.compile(patternStr);
        System.out.println(pattern.matcher(serialNumber).find());

        String patternStr1 = "\"serialNumber\":\"?([a-zA-Z0-9]*)\"?";
        Pattern pattern1 = Pattern.compile(patternStr1);
        System.out.println(pattern1.matcher(serialNumber).find());

    }
}
