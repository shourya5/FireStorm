package HTTP_Server_Module.HTTP_Response_Headers;

//import HTTP_Server_Module.HTTP_Response_Headers.HTTPHeaderResponseType;

//import HTTP_Server_Module.HTTP_Response_Headers.HTTPHeaderResponseType;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DateHeader extends HTTPHeaderResponse {
    static DateTimeFormatter  http_date_format = DateTimeFormatter.ofPattern("EEE, dd MMM yyyy HH:mm:ss z", Locale.ENGLISH).withZone(ZoneId.of("GMT"));
    static String http_formatted_date = LocalDateTime.now().format(http_date_format);
    static String date_header_label = "Date: ";

    public DateHeader() {
        super(date_header_label,http_formatted_date,HTTPHeaderResponseType.GENERAL_HEADER);
    }

}
