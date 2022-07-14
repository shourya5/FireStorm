package HTTP_Server_Module.HTTP_Response_Module;

import HTTP_Server_Module.HTTP_General_Interfaces.HTTPStartLine;

public class HTTPStatusLine implements HTTPStartLine {
    private final String HTTP_version = "HTTP/1.1";
    private final double HTTP_version_number = 1.1;
    private StatusCode status_code;

    public HTTPStatusLine(StatusCode status_code) {
        this.status_code = status_code;
    }
    public HTTPStatusLine(StoredStatusCode name) {this.status_code = StatusCode.getInstance(name);}

    @Override
    public String getLineAsString() {
    return HTTP_version + " "
        + status_code.getNumericStatusCode() + " "
        + status_code.getReasonPhrase();
        //Example : HTTP/1.1 200 OK
    }


    @Override
    public double getHttpVersion() {
        return HTTP_version_number;
    }


    @Override
    public String getHttpPVersion() {
        return HTTP_version;
    }
}
