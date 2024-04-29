package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public class File_Reader {
    private final ArrayList<BigInteger> list = new ArrayList<>();

    private void initialise(String f_path) throws FileNotFoundException {
        File file = new File(f_path);
        if (!file.exists()){
            throw new FileNotFoundException("no file at: "+f_path);
        }
        Scanner reader = null;
        try {
            reader = new Scanner(file);
        } catch (FileNotFoundException ignored) {}
        while (reader.hasNextBigInteger()){
            list.add(reader.nextBigInteger());
        }
    }

    public File_Reader(String file_path) throws FileNotFoundException {
        initialise(file_path);
    }
    public BigInteger _min(){
        BigInteger ans = list.get(0);
        for (BigInteger i: list) {
            if (i.compareTo(ans)<0){
                ans=i;
            }
        }
        return ans;
    }

    public BigInteger _max(){
        BigInteger ans = list.get(0);
        for (BigInteger i: list) {
            if (i.compareTo(ans)>0){
                ans=i;
            }
        }
        return ans;
    }

    public BigInteger _sum(){
        BigInteger s=BigInteger.ZERO;
        for (BigInteger i: list){
            s=s.add(i);
        }
        return s;
    }

    public BigInteger _mult(){
        BigInteger s=BigInteger.ONE;
        for (BigInteger i: list){
            s=s.multiply(i);
        }
        return s;
    }

    public ArrayList<BigInteger> getList() {
        return list;
    }
}

