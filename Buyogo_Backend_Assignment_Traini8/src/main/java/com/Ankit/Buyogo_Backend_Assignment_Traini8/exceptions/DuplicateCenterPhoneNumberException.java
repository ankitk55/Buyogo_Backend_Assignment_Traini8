package com.Ankit.Buyogo_Backend_Assignment_Traini8.exceptions;

public class DuplicateCenterPhoneNumberException extends RuntimeException{
    public DuplicateCenterPhoneNumberException() {
        super("Phone Number already exists..");
    }

    public DuplicateCenterPhoneNumberException(String message) {
        super(message);
    }
}
