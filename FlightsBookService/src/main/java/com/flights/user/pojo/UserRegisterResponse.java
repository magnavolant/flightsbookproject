package com.flights.user.pojo;

public class UserRegisterResponse {

    private boolean success = true;
    private String message = "CREATED";

    public UserRegisterResponse() {
    }

    public UserRegisterResponse(boolean success, String message) {
        this.success = success;
        this.message = message;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserRegisterResponse that = (UserRegisterResponse) o;

        if (success != that.success) return false;
        return message != null ? message.equals(that.message) : that.message == null;
    }
}
