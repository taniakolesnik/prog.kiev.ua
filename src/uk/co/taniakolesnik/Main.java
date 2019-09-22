package uk.co.taniakolesnik;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    private static AtomicInteger id = new AtomicInteger(1);

    public static void main(String[] args) {

        try(ServerSocket serverSocket = new ServerSocket(8080)){
            for (;;){
                Socket socket = serverSocket.accept();
                Client client = new Client(socket, id.incrementAndGet());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}