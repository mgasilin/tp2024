
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;

class ReaderTest {
    private final ArrayList<BigInteger> list = new ArrayList<>();
    private org.example.File_Reader test_reader;

    @BeforeEach
    public void setup() {
        File tmp = new File("");
        String t_path = tmp.getAbsolutePath() + "\\src\\main\\java\\text.txt";
        try {
            test_reader = new org.example.File_Reader(t_path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            Assertions.fail();
        }
        list.clear();
        list.add(new BigInteger("1"));
        list.add(new BigInteger("2"));
        list.add(new BigInteger("3"));
        list.add(new BigInteger("4"));
        list.add(new BigInteger("-1"));
        list.add(new BigInteger("3"));
        list.add(new BigInteger("-5"));
        list.add(new BigInteger("-7"));
        list.add(new BigInteger("100000000000000000000000000010000000000000000000000000000000000000000000000000000000"));
        list.add(new BigInteger("-100000000000000000000000000010000000000000000000000000000000000000000000000000000000"));
        list.add(new BigInteger("-101"));
    }

    @Test
    public void read_test_file() {
        ArrayList<BigInteger> sample = test_reader.getList();
        Assertions.assertEquals(sample, list);
    }

    @Test
    public void test_sum() {
        Assertions.assertEquals(test_reader._sum(), new BigInteger("-101"));
    }

    @Test
    public void test_min() {
        Assertions.assertEquals(test_reader._min(), new BigInteger("-100000000000000000000000000010000000000000000000000000000000000000000000000000000000"));
    }

    @Test
    public void test_max() {
        Assertions.assertEquals(test_reader._max(), new BigInteger("100000000000000000000000000010000000000000000000000000000000000000000000000000000000"));
    }

    @Test
    public void test_mult() {
        Assertions.assertEquals(test_reader._mult(), new BigInteger("-2545200000000000000000000000509040000000000000000000000025452000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000"));
    }

    /*@Test
    public void test_time() {
        int n = 1000;
        File tmp = new File("");
        String t_path = tmp.getAbsolutePath() + "\\src\\main\\java\\time_test.txt";
        tmp = new File(t_path);
        for (int test=1; test<=100; test++){
            if (!tmp.exists()){
                try {
                    tmp.createNewFile();
                } catch (IOException e) {
                    Assertions.fail();
                }
            }
            try {
                FileWriter writer = new FileWriter(t_path, true);
                BufferedWriter bufferWriter = new BufferedWriter(writer);
                for (int i = n - 999; i <= n; i++) {
                    bufferWriter.write(i+"\n");
                }
                n += 1000;
                bufferWriter.flush();
                bufferWriter.close();
            } catch (IOException e) {
                Assertions.fail();
            }
            try {
                test_reader=new org.example.File_Reader(t_path);
            } catch (FileNotFoundException e) {
                Assertions.fail();
            }
            long start = System.currentTimeMillis();
            test_reader._mult();
            long end = System.currentTimeMillis();
            System.out.println(end-start+" "+(n-1000));
        }
    }*/

}