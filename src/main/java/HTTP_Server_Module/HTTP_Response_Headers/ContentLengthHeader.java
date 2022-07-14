package HTTP_Server_Module.HTTP_Response_Headers;

import org.jetbrains.annotations.NotNull;

import java.io.File;

public class ContentLengthHeader extends HTTPHeaderResponse {

    private static final String content_length_label = "Content-Length: ";
    int content_length;

    public ContentLengthHeader(@NotNull File input_file) {

        super(content_length_label, String.valueOf(input_file.length()), HTTPHeaderResponseType.ENTITY_HEADER);
        this.content_length = (int) input_file.length();
    }
}

