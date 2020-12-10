package com.morris.leetcode;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * This program will be converted to a method, eventually, to find a github profiles title
 * description. Ultimately breaking down a github page to build a quick overview of a user's
 * work, projects, etc.
 *
 * @author Wali Morris<walimmorris@gmail.com>
 */

public class Main {

    public static void main(String[] args) throws IOException {
        StringBuilder info = new StringBuilder();
        char[] title = {'t', 'i', 't', 'l', 'e'};
        InputStream inputStream;
        URL url;
        try {
            url = new URL("https://www.github.com/walimorris");
            inputStream = url.openStream();
            int character, infoTitle = 0;
            while ((character = inputStream.read()) != -1) {
                if (character == title[infoTitle]) {
                   info.append((char) character);
                   infoTitle++;
                   if (info.toString().equals("title")) {
                       break;
                   }
                } else {
                    if (info.toString().length() > 0 ) {
                        info = new StringBuilder();
                        infoTitle = 0;
                    }
                }
            }
            inputStream.close();
        } catch ( MalformedURLException e) {
            e.printStackTrace();
        }
        System.out.println(info.toString());
    }
}