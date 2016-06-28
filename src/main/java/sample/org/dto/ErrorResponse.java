package sample.org.dto;

/**
 * Created by associate on 06/22/16.
 */
public class ErrorResponse {

    private int code;
    private String message;
    private String serviceId;

    public ErrorResponse(int code, String message, String serviceId) {
        this.code = code;
        this.message = message;
        this.serviceId = serviceId;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }
}
