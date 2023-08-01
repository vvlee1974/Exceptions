package org.example.lesson3.homeWork300.exceptions;

public class MyStringFormatSex extends RuntimeException{
    /**
     * Constructs a new runtime exception with {@code null} as its
     * detail message.  The cause is not initialized, and may subsequently be
     * initialized by a call to {@link #initCause}.
     */
    public MyStringFormatSex() {
        super("Введены не корректные данные. Повторите ввод f/m");
    }
}
