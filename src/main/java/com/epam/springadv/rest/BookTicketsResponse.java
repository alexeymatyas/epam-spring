package com.epam.springadv.rest;

/**
 * Created by Alexey on 30.10.2016.
 */
public class BookTicketsResponse {
    private String status;

    private String errorMessage;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
