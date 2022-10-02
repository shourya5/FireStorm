import HTTP_Server_Module.Server_FrontEnd.HTTPServer;

public class main {
    public static void main(String[] args) {
        System.out.println("Starting server");
        HTTPServer server = new HTTPServer();
        server.startServer();
        System.out.println("Server connection closed");
    }
}
