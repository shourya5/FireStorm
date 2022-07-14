package HTTP_Server_Module.HTTP_Response_Module;

import java.util.NoSuchElementException;

public enum StatusCodeCategory {
    INFORMATIONAL(100, 199),
    SUCCESS(200, 299),
    REDIRECTION(300, 399),
    CLIENT_ERROR(400, 499),
    SERVER_ERROR(500, 599);

    private int lowerBound;

    private int upperBound;

    StatusCodeCategory(int lowerBound, int upperBound) {
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
    }

    public boolean isInCategory(int statusCode) {
        return statusCode >= lowerBound && statusCode <= upperBound;
    }

    public static StatusCodeCategory getCategory(int statusCode) {
        for (StatusCodeCategory status_code :
                StatusCodeCategory.values()) {
            if(status_code.isInCategory(statusCode)) return status_code;

        }
        throw new NoSuchElementException("Status Code not found");
    }
}
