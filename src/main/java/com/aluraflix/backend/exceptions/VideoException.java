package com.aluraflix.backend.exceptions;

import org.springframework.http.HttpStatus;
public class VideoException extends RuntimeException {

    private HttpStatus status;
    private String mensageDetail;

    public VideoException() {
    }

    public VideoException(HttpStatus status, String message, String mensageDetail) {
        super (message);
        this.status = status;
        this.mensageDetail = mensageDetail;
    }

    public VideoException(HttpStatus status, String message) {
        super (message);
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getMensageDetail() {
        return mensageDetail;
    }
}
