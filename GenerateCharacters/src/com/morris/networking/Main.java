package com.morris.networking;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

import static com.morris.networking.GenerateCharacters.generateCharacters;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * This first portion of the program is an example using the generateCharacters method
         * which generates an infinite outputstrem of characters to a txt file.
         */
        final String OUTPUT = "/tmp/generatedCharacters.txt";              // sends output stream to this file
        System.out.println("Infinite stream will be sent to: " + OUTPUT);
        try (OutputStream out = new FileOutputStream(OUTPUT)) {            // initializes new file output stream
          generateCharacters(out);                                         // sends an infinite stream to file
          System.out.println("output sent to file: " + OUTPUT);            // will this statement ever be reached?
        } catch (IOException e) {
          System.err.println(e.getMessage());                              // catches and prints error if one occurs
        }

        /**
         * This example attempts to read in an byte array from a test file containing
         * characters. This would be a nice way to scramble output, incorporating a
         * function to change every bit...
         */
        final String FILETYPE = ".txt";                                                                 // Declares type of file
        final String INPUT = "/home/tuvok/network/readtest" + FILETYPE;                                 // File to read
        final String FILEOUTPUT = INPUT.substring(0, INPUT.length() - 4) + "_bytefile" + FILETYPE;      // add _bytefile to end
        Path path = Paths.get(INPUT);                                                                   // get path to input file
        byte[] data = Files.readAllBytes(path);                                                         // read input file
        try (OutputStream out = new FileOutputStream(FILEOUTPUT)) {                                     // create output file
            for (byte datum : data) {
                out.write(datum);                                                                       // write bytes to output file
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        System.out.println(Arrays.toString(data));
    }
}