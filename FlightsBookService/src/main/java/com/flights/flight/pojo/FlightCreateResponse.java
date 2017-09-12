package com.flights.flight.pojo;

public class FlightCreateResponse {
    private boolean success = true;
    private String message = "CREATED";


    public FlightCreateResponse (){}

    public FlightCreateResponse(boolean success, String message) {
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
}
