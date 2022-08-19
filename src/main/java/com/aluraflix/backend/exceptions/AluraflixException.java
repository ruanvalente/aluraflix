package com.aluraflix.backend.exceptions;

import org.springframework.http.HttpStatus;
public class AluraflixException extends RuntimeException {

    private HttpStatus status;
    private String mensageDetail;

    public AluraflixException() {
    }

    public AluraflixException(HttpStatus status, String message, String mensageDetail) {
        super (message);
        this.status = status;
        this.mensageDetail = mensageDetail;
    }

    public AluraflixException(HttpStatus status, String message) {
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
