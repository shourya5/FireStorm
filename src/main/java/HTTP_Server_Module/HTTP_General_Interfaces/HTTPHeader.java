package HTTP_Server_Module.HTTP_General_Interfaces;

public interface HTTPHeader {
    public  String getLabel();
    public String getContent();
    //int getHeaderPriority();//0 is highest, 1 is second highest, etc.
    public  String asString();


}

