package com.morris.networking;

import java.io.IOException;
import java.io.OutputStream;

public class GenerateCharacters {
    public static void generateCharacters(OutputStream out) throws IOException {
        int firstPrintableCharacter = 33;
        int numberOfPrintableCharacters = 94;
        int numberOfCharactersPerLine = 72;
        int start = firstPrintableCharacter;
        byte[] line = new byte[numberOfCharactersPerLine + 2];                      // +2 is for the carriage return and linefeed

        while (true) {                                                              // BEWARE: INFINITE LOOP!
            for (int i = start; i < start + numberOfCharactersPerLine; i++) {
                line[i - start] = (byte) ((i - firstPrintableCharacter)
                        % numberOfPrintableCharacters + firstPrintableCharacter);
            }
            line[72] = (byte) '\r';                                                 // carriage return
            line[73] = (byte) '\n';                                                 // line feed
            out.write(line);
            start = ((start + 1) - firstPrintableCharacter)
                    % numberOfPrintableCharacters + firstPrintableCharacter;
        }
    }
}
