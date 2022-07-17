package HTTP_Server_Module.HTTP_Response_Headers;



public class ContentTypeHeader extends HTTPHeaderResponse {
    private static final String content_type_label = "Content-Type: ";
    private final String content_type_value = "";

    private HeaderContentType content_type;



    public ContentTypeHeader(HeaderContentType content_type) {
        super(content_type_label,content_type.getContentType(), HTTPHeaderResponseType.ENTITY_HEADER);
    }

}