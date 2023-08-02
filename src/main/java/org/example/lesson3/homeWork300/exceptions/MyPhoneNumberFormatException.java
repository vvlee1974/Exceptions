package org.example.lesson3.homeWork300.exceptions;

public class MyPhoneNumberFormatException extends RuntimeException{
    public MyPhoneNumberFormatException() {
        super("Неправильный формат телефона. Необходимо повторить ввод.");
    }
}
