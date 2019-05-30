package Testing;

import Main.HuffmanEncoding.HuffmanCoding;
import Main.HuffmanEncoding.Node;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

public class HuffmanTreeTesting {
    @Test
    public void simple1(){
        try {
            Method toTest = HuffmanCoding.class.getDeclaredMethod("generateTree",String.class);
            toTest.setAccessible(true);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
