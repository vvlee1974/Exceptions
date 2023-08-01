package org.example.lesson3.homeWork300.exceptions;

public class MyStringFormatName extends RuntimeException{
    public MyStringFormatName() {
        super("Введены не полные данные ФИО. Повторите ввод.");
    }
}
