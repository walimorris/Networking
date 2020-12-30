package com.morris.networking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleEchoServer {
    private final ServerSocket server;

    public SimpleEchoServer(int port) throws IOException {
        server = new ServerSocket(port);
    }

    public boolean echoServerIsRunning() {
        return !(server.isClosed());
    }

    public void shutDownEchoServer() throws IOException {
        server.close();
    }

    public Socket receiveClientSocket() throws IOException {
        System.out.println("Waiting for connection request...");
        Socket clientSocket = server.accept();
        System.out.println("connected to: " + clientSocket.getInetAddress());

        return clientSocket;
    }

    public BufferedReader createClientWriter(Socket clientSocket) throws IOException {
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(
                clientSocket.getInputStream()));
        } catch (IOException e) {
            System.out.println(e.getMessage());
            server.close();
        }
        return bufferedReader;
    }

    public int getHostIp() {
        return Integer.getInteger(server.getInetAddress().toString());
    }
}
