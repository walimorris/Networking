package com.morris.networking;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;

/**
 * Program that reads my github page's information. Note: {@link URL} throws {@link java.net.MalformedURLException}.
 * Since the {@link java.net.MalformedURLException} is a subclass of {@link IOException}, both exceptions are caught.
 * The output(object) is given a choice, depending how the resource output can be read, it writes to the console by
 * deciding by Class. If {@link String}, writes output as String. If {@link Reader}, writes as Reader. If {@link InputStream},
 * writes as InputStream.
 *
 */

public class Main {

    public static void main(String[] args) {
        URL url;
        try {
            url = new URL("https://www.github.com/walimorris");
            Class<?>[] types = {String.class, Reader.class, InputStream.class};
            Object object = url.getContent();
            if ( object instanceof String ) {
                System.out.println(object);
            } else if ( object instanceof Reader) {
                int c;
                Reader reader = (Reader) object;
                while ((c = reader.read()) != -1) {
                    System.out.println((char) c);
                }
                reader.close();
            } else if (object instanceof InputStream ) {
                int c;
                InputStream inputStream = (InputStream) object;
                while ((c = inputStream.read()) != -1) {
                    System.out.write(c);
                }
                inputStream.close();
            } else {
                System.out.println("Error: unexpected type " + object.getClass());
            }
        } catch (IOException e ) {
            e.printStackTrace();
        }
    }
}
