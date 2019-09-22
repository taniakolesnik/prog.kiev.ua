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
        StringBuilder builder = new StringBuilder("System info: for request:" + id);
        builder.append("<br> processors: " + Runtime.getRuntime().availableProcessors());
        builder.append("<br>  free memory: " + Runtime.getRuntime().freeMemory());
        builder.append("<br>  total memory: " + Runtime.getRuntime().totalMemory());
        try (OutputStream outputStream = socket.getOutputStream(); InputStream inputStream = socket.getInputStream()){
            PrintWriter printWriter = new PrintWriter(outputStream);
            byte[] request = new byte[inputStream.available()];
            inputStream.read(request);


            printWriter.print("HTTP/1.0 200 OK\r\n");
            printWriter.print("Content-Type: text/html\r\n");
            printWriter.print("\r\n");
            printWriter.print("<html><head><TITLE>Test</TITLE></head><body><P>" + builder.toString() + "</P></body></html>");
            printWriter.flush();

        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
