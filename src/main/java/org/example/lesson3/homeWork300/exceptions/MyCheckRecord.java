package org.example.lesson3.homeWork300.exceptions;

public class MyCheckRecord extends RuntimeException{

    public MyCheckRecord() {
        System.out.println("Запись содержит незаполненные параметры. Необходимо повторить ввод.");
    }
}
