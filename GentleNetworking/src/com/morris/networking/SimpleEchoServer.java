package com.morris.networking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleEchoServer {
    ServerSocket server;

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

    public PrintWriter createClientWriter(Socket clientSocket) throws IOException {
        PrintWriter clientWriter = null;
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(
                clientSocket.getInputStream()))) {
            clientWriter = new PrintWriter(clientSocket.getOutputStream(), true);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            server.close();
        }
        return clientWriter;
    }


}
