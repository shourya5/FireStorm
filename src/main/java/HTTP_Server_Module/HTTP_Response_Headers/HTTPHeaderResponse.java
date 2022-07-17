package HTTP_Server_Module.HTTP_Response_Headers;

//import HTTP_Server_Module.HTTP_General_Interfaces.HTTPHeader;

import HTTP_Server_Module.HTTP_General_Interfaces.HTTPHeader;

public abstract   class HTTPHeaderResponse implements HTTPHeader {

    private final String response_label;
    private HTTPHeaderResponseType response_type = null;
     private String content = "";

    public HTTPHeaderResponse(String response_label,String content ,HTTPHeaderResponseType response_type ) {
        this.response_label = response_label;
        this.content = content;
        this.response_type = response_type;
    }




    @Override
    public String getLabel() {
        return response_label;
    }

    @Override
    public String getContent() {
        return  content;
    }

    public String asString() {
        return (response_label + content);
    }
}
