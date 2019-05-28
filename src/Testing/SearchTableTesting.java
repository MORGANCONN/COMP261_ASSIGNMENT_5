package Testing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static Main.KMP.generateKMPSearchTable;

public class SearchTableTesting {

    @Test
    public void basic1(){
        int expected[] = {0,0,0,0,1,2,3};
        int generated[] = generateKMPSearchTable("abcdabc");
        Assertions.assertArrayEquals(expected,generated);
    }

    @Test
    public void basic2(){
        int expected[] = {0,0,0,0,1,2,3};
        int generated[] = generateKMPSearchTable("zfcazfc");
        Assertions.assertArrayEquals(expected,generated);
    }

    @Test
    public void basic3(){
        int expected[] = {0,0,1,0,1,2,3};
        int generated[] = generateKMPSearchTable("lmlzlml");
        Assertions.assertArrayEquals(expected,generated);
    }

}
