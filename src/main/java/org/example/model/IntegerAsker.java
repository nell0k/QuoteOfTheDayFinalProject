package org.example.model;


import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class IntegerAsker {
    private final Scanner scanner;
    private final PrintStream out;

    public IntegerAsker() {
        scanner = new Scanner(System.in);
        this.out = System.out;
    }

    public int ask(String message) {
        out.println(message);
        return scanner.nextInt();
    }
}
