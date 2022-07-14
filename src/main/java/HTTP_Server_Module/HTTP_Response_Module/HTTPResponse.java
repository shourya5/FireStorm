package HTTP_Server_Module.HTTP_Response_Module;

import HTTP_Server_Module.HTTP_Response_Headers.HTTPHeaderResponse;


public class HTTPResponse {
    private HTTPStatusLine status_line;
    private HTTPHeaderResponse[] headers;
    private String message_body;
    private static final String CRLF = "\r\n";

    private String HTTPHeaderArrayDisplay(){
        String  out = "";
        for (var header:
             headers) {
        out += header.asString() + CRLF;
        }
        return out;
    }

    public HTTPResponse(HTTPStatusLine status_line,String message_body,HTTPHeaderResponse... headers) {
        this.status_line = status_line;
        this.headers = headers;
        this.message_body = message_body;
    }

    public String getAsString() {
    String output = status_line.getLineAsString() + CRLF
                    + HTTPHeaderArrayDisplay()
                    + CRLF
                    + message_body;
    return output;

    }

}
