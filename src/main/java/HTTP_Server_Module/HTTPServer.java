package HTTP_Server_Module;

import HTTP_Server_Module.HTTP_Concurrent_Worker.ThreadWorker;
import HTTP_Server_Module.HTTP_Response_Headers.*;
import HTTP_Server_Module.HTTP_Response_Module.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HTTPServer {

    static int port  = 8080;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(port);) {
            serverSocket.setReuseAddress(true);
            ExecutorService threadPool = Executors.newFixedThreadPool(10);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                threadPool.execute(new ThreadWorker(clientSocket));

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



}

