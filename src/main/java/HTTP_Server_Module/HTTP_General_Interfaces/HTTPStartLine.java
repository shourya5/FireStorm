package HTTP_Server_Module.HTTP_General_Interfaces;

public interface HTTPStartLine {
    public String getLineAsString();
    double getHttpVersion();
    String getHttpPVersion();
}
