package shixzh.j2x3.y2017.m07.d03;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.Set;

public class CharsetTest {

    public static void main(String[] args) {
        Charset cset = Charset.forName("ISO-8859-1");
        Set<String> aliases = cset.aliases();
        for(String alias : aliases) {
            System.out.println("aliases: " + alias);
        }

        Map<String, Charset> charsets = Charset.availableCharsets();
        for(String name : charsets.keySet()) {
            System.out.println("availableCharsets: " + name);
        }
        
        byte[] bytes = {1,2};
        int offset = 0;
        int length = bytes.length;
        ByteBuffer bbuf = ByteBuffer.wrap(bytes, offset, length);
        CharBuffer cbuf = cset.decode(bbuf);
        String str = cbuf.toString();
        System.out.println("charBuffer: " + str);
    }

}
