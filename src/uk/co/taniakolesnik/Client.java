package uk.co.taniakolesnik;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class Client implements Runnable {
    private Socket socket;
    private int id;
    private Thread thread;

    public Client(Socket socket, int id) {
        this.socket = socket;
        this.id = id;
        thread = new Thread(this);
        thread.start();
    }


    @Override
    public void run() {
        System.out.println("started for " + id);
        String answer = "No info. Connection :" + id;
        try (OutputStream outputStream = socket.getOutputStream(); InputStream inputStream = socket.getInputStream()){
            PrintWriter printWriter = new PrintWriter(outputStream);
            byte[] request = new byte[inputStream.available()];
            inputStream.read(request);


            printWriter.print("HTTP/1.0 200 OK\r\n");
            printWriter.print("Content-Type: text/html\r\n");
            printWriter.print("\r\n");
            printWriter.print("<html><head><TITLE>Test</TITLE></head><body><P>" + answer + "</P></body></html>");
            printWriter.flush();

        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
