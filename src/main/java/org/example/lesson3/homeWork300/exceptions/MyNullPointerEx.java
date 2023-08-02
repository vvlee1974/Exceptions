package org.example.lesson3.homeWork300.exceptions;

public class MyNullPointerEx extends NullPointerException{
    /**
     * Constructs a {@code NullPointerException} with no detail message.
     */
    public MyNullPointerEx() {
        super("Необходимо ввести ФИО через пробел.");
    }
}

