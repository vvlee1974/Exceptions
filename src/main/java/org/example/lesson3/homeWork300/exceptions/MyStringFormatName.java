package org.example.lesson3.homeWork300.exceptions;

public class MyStringFormatName extends RuntimeException{
    public MyStringFormatName() {
        super("Введены некорректные данные ФИО. Повторите ввод.");
    }
}
