package com.Ankit.Buyogo_Backend_Assignment_Traini8.exceptions;

public class DuplicateCenterNameException extends RuntimeException{
    public DuplicateCenterNameException() {
        super("Center_Name already Exists..");
    }

    public DuplicateCenterNameException(String message) {
        super(message);
    }
}
