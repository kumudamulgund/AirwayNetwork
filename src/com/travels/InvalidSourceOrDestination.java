package com.travels;

public class InvalidSourceOrDestination extends Exception {

    private final String message;

    public InvalidSourceOrDestination(final String message) {
        this.message = message;
    }
}
