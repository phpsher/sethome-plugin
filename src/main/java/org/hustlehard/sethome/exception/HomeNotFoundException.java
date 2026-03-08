package org.hustlehard.sethome.exception;

public class HomeNotFoundException extends RuntimeException {
    public HomeNotFoundException(String message) {
        super(message);
    }
}
