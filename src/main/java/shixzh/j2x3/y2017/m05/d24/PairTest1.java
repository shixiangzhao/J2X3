package shixzh.j2x3.y2017.m05.d24;

public class PairTest1 {

    public static void main(String[] args) {
        String[] words = { "I", "am", "Jack", "007" };
        Pair<String> ss = ArrayAlg.minmaxString(words);
        System.out.println("string min = " + ss.getFirst());
        System.out.println("string max = " + ss.getSecond());

        Integer[] ints = { 34, 23, 12, 45 };
        Pair<Integer> ii = ArrayAlg.minmaxInteger(ints);
        System.out.println("integer min = " + ii.getFirst());
        System.out.println("integer max = " + ii.getSecond());

        Integer[] ints2 = { 34, 23, 13, 49 };
        Pair<Integer> ii2 = ArrayAlg.minmaxInteger(ints2);
        System.out.println("integer min = " + ii2.getFirst());
        System.out.println("integer max = " + ii2.getSecond());

        String[] words2 = { "I", "bm", "Jack", "008" };
        Pair<String> ss2 = ArrayAlg.minmaxString(words2);
        System.out.println("string min = " + ss2.getFirst());
        System.out.println("string max = " + ss2.getSecond());
    }
}
