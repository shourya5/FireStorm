package HTTP_Server_Module.HTTP_Response_Headers;

public class ServerNameHeader extends HTTPHeaderResponse{
    String server_name;
    public ServerNameHeader(String server_name) {

        super("Server: ", server_name, HTTPHeaderResponseType.ENTITY_HEADER);
        this.server_name = server_name;
    }
}
