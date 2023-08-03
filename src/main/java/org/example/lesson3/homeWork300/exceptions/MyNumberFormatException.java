package org.example.lesson3.homeWork300.exceptions;

public class MyNumberFormatException extends NumberFormatException{

    /**
     * Constructs a {@code NumberFormatException} with no detail message.
     */
    public MyNumberFormatException() {
        super("-");
    }
}
