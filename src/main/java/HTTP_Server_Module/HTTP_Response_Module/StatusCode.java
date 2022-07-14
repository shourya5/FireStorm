package HTTP_Server_Module.HTTP_Response_Module;

import java.util.concurrent.ConcurrentHashMap;

public  class StatusCode {
    private static final ConcurrentHashMap<StoredStatusCode,StatusCode> stored_status_codes = new ConcurrentHashMap<>();
    protected int numeric_status_code;
    protected StatusCodeCategory status_code_category;
    protected String reason_phrase;
 static {
     for(StoredStatusCode status_code : StoredStatusCode.values()) {
         var insert_value = new StatusCode(status_code.getCode(),StatusCodeCategory.getCategory(status_code.getCode()),status_code.getReason_phrase());
         stored_status_codes.put(status_code,insert_value);
     }
 }
public StatusCode(int numeric_status_code, StatusCodeCategory status_code_category, String reason_phrase) {
        this.numeric_status_code = numeric_status_code;
        this.status_code_category = status_code_category;
        this.reason_phrase = reason_phrase;
    }
    public static StatusCode getInstance(StoredStatusCode name) {
     return stored_status_codes.get(name);
    }

    public String getReasonPhrase() {
        return reason_phrase;
    }
    public int getNumericStatusCode() {
        return numeric_status_code;
    }
public StatusCodeCategory getStatusCodeCategory() {
        return status_code_category;
    }

}
