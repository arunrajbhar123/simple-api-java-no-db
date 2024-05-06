package org.example.user;

public  class UserResponse {
    private Object data;
    private final String status;
    private String error;


    public UserResponse(Object data, String status) {
        this.data = data;
        this.status = status;
    }

    public UserResponse(String error, String status) {
        this.error = error;
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public String getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }
}
