package HTTP_Server_Module.Server_FrontEnd;

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
    static String default_port = "8080";
    static String default_root = "src/main/java/HTTP_Server_Module/TestFile.html";
    //change both as required

    static int port = Integer.parseInt(System.getenv().getOrDefault("PORT", default_port));
    static String path = System.getenv().getOrDefault("PATH", default_root);
    //Checks for the PORT environment variable, if it doesn't exist, it defaults to 8080

    public void startServer() {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            serverSocket.setReuseAddress(true);
            Document htmlDocument = Jsoup.parse(new File(path), "UTF-8");
            ExecutorService threadPool = Executors.newFixedThreadPool(10);
            while (true) {///infinite loop to finish all processes
                Socket clientSocket = serverSocket.accept();
                threadPool.execute(new ThreadWorker(clientSocket, htmlDocument));

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }






}

