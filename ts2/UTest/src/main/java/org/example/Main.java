package org.example;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            File_Reader reader = new File_Reader("D:\\Java+Kotlin\\Java\\UTest\\src\\main\\java\\org\\example\\text.txt");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println("D:\\Java+Kotlin\\Java\\UTest\\src\\main\\java\\org\\example\\text.txt");
    }
}