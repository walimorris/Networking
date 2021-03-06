package com.morris.networking;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException {
        SimpleEchoServer echoServer = new SimpleEchoServer(6000);
        System.out.println("EchoServer running: " + echoServer.echoServerIsRunning());

        Socket clientSocket = echoServer.receiveClientSocket();
        BufferedReader clientWriter = echoServer.createClientWriter(clientSocket);

        String incoming;
        while ((incoming = clientWriter.readLine()) != null) {
            System.out.println("Server: " + incoming);


        try {
            Thread.sleep(2000);
        } catch(InterruptedException e) {
            System.out.println("Sleep process interrupted, closing thread.");
            if (echoServer.echoServerIsRunning()) {
                echoServer.shutDownEchoServer();
            }
            System.out.println("After Interruption: Echo Server shutdown.");
        }
        echoServer.shutDownEchoServer();
        System.out.println("EchoServer has been shutdown!");
    }
}
