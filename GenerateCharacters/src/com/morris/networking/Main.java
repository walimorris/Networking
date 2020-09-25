package com.morris.networking;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import static com.morris.networking.GenerateCharacters.generateCharacters;

public class Main {
    public static void main(String[] args) {
        final String OUTPUT = "/tmp/generatedCharacters.txt";              // sends output stream to this file
        System.out.println("Infinite stream will be sent to: " + OUTPUT);
        try (OutputStream out = new FileOutputStream(OUTPUT)) {            // initializes new file output stream
            generateCharacters(out);                                       // sends an infinite stream to file
            System.out.println("output sent to file: " + OUTPUT);          // will this statement ever be reached?
        } catch (IOException e) {
            System.err.println(e.getMessage());                            // catches and prints error if one occurs
        }
    }
}

