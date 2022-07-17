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

    public void startServer(int server_port) {
        try (ServerSocket serverSocket = new ServerSocket(server_port);) {
            serverSocket.setReuseAddress(true);
            Document htmlDocument = Jsoup.parse(new File("src/main/java/HTTP_Server_Module/TestFile.html"), "UTF-8");
            ExecutorService threadPool = Executors.newFixedThreadPool(10);
            while (true) {///infinite loop to finish all processes
                Socket clientSocket = serverSocket.accept();
                threadPool.execute(new ThreadWorker(clientSocket, htmlDocument));

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        HTTPServer server = new HTTPServer();
        server.startServer(port);
    }



}

