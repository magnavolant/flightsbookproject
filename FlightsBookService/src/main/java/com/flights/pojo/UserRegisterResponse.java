package com.flights.pojo;

public class UserRegisterResponse {

    private boolean success = true;
    private String message = "OK";

    public UserRegisterResponse() {
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
