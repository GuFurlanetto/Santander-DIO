package com.digitalinoccation.one.conferenceroom.exception;


import java.util.Date;

public class ErrorDetails {

    private Date dateStamp;

    private String message;

    private String details;


    public ErrorDetails(Date dateStamp, String message, String details) {
        this.dateStamp = dateStamp;
        this.message = message;
        this.details = details;
    }

    public Date getDateStamp() {
        return dateStamp;
    }

    public void setDateStamp(Date dateStamp) {
        this.dateStamp = dateStamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
