package HTTP_Server_Module.HTTP_Response_Headers;

import org.jetbrains.annotations.NotNull;
import org.jsoup.nodes.Document;

import java.io.File;

public class ContentLengthHeader extends HTTPHeaderResponse {

    private static final String content_length_label = "Content-Length: ";
    int content_length;



    public ContentLengthHeader(@NotNull Document document) {

        super(content_length_label, String.valueOf(document.outerHtml().length()), HTTPHeaderResponseType.ENTITY_HEADER);
        this.content_length = document.outerHtml().length();
    }
}

