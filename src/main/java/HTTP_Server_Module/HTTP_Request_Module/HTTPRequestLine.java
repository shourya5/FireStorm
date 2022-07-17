package HTTP_Server_Module.HTTP_Request_Module;

import HTTP_Server_Module.HTTP_General_Interfaces.HTTPStartLine;

public class HTTPRequestLine implements HTTPStartLine {
    private final String HTTP_version = "HTTP/1.1";
    private final double HTTP_version_number = 1.1;

    private String path_component = ""; // path component of the request line

    private HTTPRequestMethod method;

    HTTPRequestLine(String start_line) {
        String[] start_line_split = start_line.split(" ");
        this.method = HTTPRequestMethod.valueOf(start_line_split[0]);
        this.path_component = start_line_split[1];
    }

    @Override
    public String getLineAsString() {
        return (this.method.toString() + " " + this.path_component + " " + this.HTTP_version);
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
