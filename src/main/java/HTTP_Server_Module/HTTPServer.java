package HTTP_Server_Module;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import javax.swing.text.html.HTML;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;
import java.util.stream.Collectors;

public class HTTPServer {
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public void start(int port) throws IOException {
        serverSocket = new ServerSocket(port);

        while (true) {
            try (Socket socket = serverSocket.accept()) {
                clientSocket = socket;
                out = new PrintWriter(clientSocket.getOutputStream(), true);
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                String inputLine;
                ArrayList<String> inputLines = new ArrayList<>();
                for(; (inputLine = in.readLine()) != null;) {
                    inputLines.add(inputLine);
                    if (inputLine.isEmpty()) {
                        break;
                    }
                }
                File input = new File("src/main/java/HTTP_Server_Module/TestFile.html");
                Document doc = Jsoup.parse(input,"UTF-8",""); // this works
                System.out.println(inputLines);
                    String response = "";



                response = "HTTP/1.1 200 OK\r\n" +
                                "Date: " + new Date() + "\r\n" +
                                "Server: FireStorm\r\n" +
                                "Content-Type: text/html\r\n" +
                                "Content-Length:" + input.length()+ "\r\n" +
                                "\r\n" + doc.toString();


                    out.println(response);
                }

            }
        }



    public void stop() throws IOException {
        in.close();
        out.close();
        clientSocket.close();
        serverSocket.close();
    }
    public static void main(String[] args) throws IOException {
        HTTPServer server=new HTTPServer();
        server.start(8080);
        server.stop();

    }
}

