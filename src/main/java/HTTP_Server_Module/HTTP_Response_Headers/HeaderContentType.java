package HTTP_Server_Module.HTTP_Response_Headers;

public enum HeaderContentType {
    HTML("text/html"),
    TEXT("text/plain"),
    JSON("application/json"),
    XML("application/xml"),
    JPEG("image/jpeg"),
    PNG("image/png"),
    GIF("image/gif"),
    BINARY("application/octet-stream");

    private String contentType;

    HeaderContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getContentType() {
        return contentType;
    }
}
