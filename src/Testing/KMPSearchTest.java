package Testing;

import Main.KMP;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KMPSearchTest {
    @Test
    public void simple1(){
        String text = "The quick brown fox";
        String pattern = "quick";
        ArrayList<Long> timesTaken = new ArrayList<>();
        ArrayList<Integer> operationsTaken = new ArrayList<>();
        for(int i = 0;i<100;i++){
            KMP search = new KMP(pattern,text);
            assertEquals(4,search.search());
            timesTaken.add(search.timeTaken);
            operationsTaken.add(search.comparisons);
        }
        System.out.print("Average Execution Time: "+timesTaken.stream().mapToLong(Long::longValue).sum()/100+"\n"+"Average Operations Taken: "+operationsTaken.stream().mapToInt(Integer::intValue).sum()/100+"\n");
    }

    @Test
    public void simple2(){
        String text = "The quick brown fox";
        String pattern = "brown";
        ArrayList<Long> timesTaken = new ArrayList<>();
        ArrayList<Integer> operationsTaken = new ArrayList<>();
        for(int i = 0;i<100;i++){
            KMP search = new KMP(pattern,text);
            assertEquals(10,search.search());
            timesTaken.add(search.timeTaken);
            operationsTaken.add(search.comparisons);
        }
        System.out.print("Average Execution Time: "+timesTaken.stream().mapToLong(Long::longValue).sum()/100+"\n"+"Average Operations Taken: "+operationsTaken.stream().mapToInt(Integer::intValue).sum()/100+"\n");
    }

    @Test
    public void simple3(){
        String text = "The quick broken bright brown fox";
        String pattern = "brown";
        ArrayList<Long> timesTaken = new ArrayList<>();
        ArrayList<Integer> operationsTaken = new ArrayList<>();
        for(int i = 0;i<100;i++){
            KMP search = new KMP(pattern,text);
            assertEquals(24,search.search());
            timesTaken.add(search.timeTaken);
            operationsTaken.add(search.comparisons);
        }
        System.out.print("Average Execution Time: "+timesTaken.stream().mapToLong(Long::longValue).sum()/100+"\n"+"Average Operations Taken: "+operationsTaken.stream().mapToInt(Integer::intValue).sum()/100+"\n");
    }

    @Test
    public void simpleBrute1(){
        String text = "The quick brown fox";
        String pattern = "quick";
        ArrayList<Long> timesTaken = new ArrayList<>();
        ArrayList<Integer> operationsTaken = new ArrayList<>();
        for(int i = 0;i<100;i++){
            KMP search = new KMP(pattern,text);
            assertEquals(4,search.bruteForce());
            timesTaken.add(search.timeTaken);
            operationsTaken.add(search.comparisons);
        }
        System.out.print("Average Execution Time: "+timesTaken.stream().mapToLong(Long::longValue).sum()/100+"\n"+"Average Operations Taken: "+operationsTaken.stream().mapToInt(Integer::intValue).sum()/100+"\n");
    }

    @Test
    public void simpleBrute2(){
        String text = "The quick brown fox";
        String pattern = "brown";
        ArrayList<Long> timesTaken = new ArrayList<>();
        ArrayList<Integer> operationsTaken = new ArrayList<>();
        for(int i = 0;i<100;i++){
            KMP search = new KMP(pattern,text);
            assertEquals(10,search.bruteForce());
            timesTaken.add(search.timeTaken);
            operationsTaken.add(search.comparisons);
        }
        System.out.print("Average Execution Time: "+timesTaken.stream().mapToLong(Long::longValue).sum()/100+"\n"+"Average Operations Taken: "+operationsTaken.stream().mapToInt(Integer::intValue).sum()/100+"\n");
    }

    @Test
    public void simpleBrute3(){
        String text = "The quick broken bright brown fox";
        String pattern = "brown";
        ArrayList<Long> timesTaken = new ArrayList<>();
        ArrayList<Integer> operationsTaken = new ArrayList<>();
        for(int i = 0;i<100;i++){
            KMP search = new KMP(pattern,text);
            assertEquals(24,search.bruteForce());
            timesTaken.add(search.timeTaken);
            operationsTaken.add(search.comparisons);
        }
        System.out.print("Average Execution Time: "+timesTaken.stream().mapToLong(Long::longValue).sum()/100+"\n"+"Average Operations Taken: "+operationsTaken.stream().mapToInt(Integer::intValue).sum()/100+"\n");
    }
}
