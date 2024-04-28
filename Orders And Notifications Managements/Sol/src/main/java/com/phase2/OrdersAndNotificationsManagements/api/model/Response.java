package com.phase2.OrdersAndNotificationsManagements.api.model;

public class Response {

    private boolean status;
    private String message;

    public Response(){}
    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}