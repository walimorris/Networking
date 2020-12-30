package com.morris.networking;

import java.io.IOException;
import java.net.ServerSocket;

public class SimpleEchoClient {

    public SimpleEchoClient(SimpleEchoServer host, int port) throws IOException {
        int hostip = host.getHostIp();
        ServerSocket client = new ServerSocket(hostip, port);
        System.out.println("Client: connected to host at " + hostip);
    }

    public 
}
