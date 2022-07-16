package HTTP_Server_Module.HTTP_Concurrent_Worker;

import HTTP_Server_Module.HTTP_Response_Headers.*;
import HTTP_Server_Module.HTTP_Response_Module.HTTPResponse;
import HTTP_Server_Module.HTTP_Response_Module.HTTPStatusLine;
import HTTP_Server_Module.HTTP_Response_Module.StoredStatusCode;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ThreadWorker  implements Runnable {
    private final Socket clientsocket;
    public ThreadWorker(Socket clientsocket) {
        this.clientsocket = clientsocket;
    }
    /**
     * When an object implementing interface {@code Runnable} is used
     * to create a thread, starting the thread causes the object's
     * {@code run} method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method {@code run} is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        try(
                BufferedReader clientin = new BufferedReader(new InputStreamReader(clientsocket.getInputStream()));
                PrintWriter clientout = new PrintWriter(clientsocket.getOutputStream(),true);


        ) {
            String inputLine;
            while ((inputLine = clientin.readLine()) != null) {
                //inputLines.add(inputLine);
                if (inputLine.isEmpty()) {
                    break;
                }
            }
            File input = new File("src/main/java/HTTP_Server_Module/TestFile.html");
            Document doc = Jsoup.parse(input,"UTF-8",""); // this works
            HTTPResponse test_response = new HTTPResponse(
                    new HTTPStatusLine(StoredStatusCode.OK),
                    doc.toString(),
                    new DateHeader(),
                    new ServerNameHeader("Firestorm"),
                    new ContentTypeHeader(HeaderContentType.HTML),
                    new ContentLengthHeader(input));
            clientout.print(test_response.getAsString());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        finally {
            try {
                clientsocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}

