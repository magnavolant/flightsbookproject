package com.flights.user.pojo;


import org.springframework.stereotype.Component;

@Component
public class UserRegisterResponse {

    private boolean success = true;

    public UserRegisterResponse() {
    }


    public UserRegisterResponse(boolean success) {
        this.success = success;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserRegisterResponse that = (UserRegisterResponse) o;

        if (success != that.success){
            return false;
        } else
            return true;
    }
}
