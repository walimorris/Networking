package com.morris.networking;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Main {
    public static void main(String[] args) {
        final String OUTPUT = "/tmp/generatedCharacters.txt";
        OutputStream out = null;
        try {
            out = new FileOutputStream(OUTPUT);
            System.out.println("data written to file.");
        } catch (IOException e) {
            System.err.println(e.getMessage());
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    System.err.println("fail to close output stream");
                }
            }
        }
    }
}
