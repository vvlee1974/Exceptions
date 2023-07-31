package org.example.lesson3.classWork300.ex301;

import java.io.IOException;

// Создайте метод doSomething(), который может быть источником одного из типов checked exceptions
// (тело самого метода прописывать необязательно).
// Вызовите этот метод из main и обработайте в нем исключение, которое вызвал метод doSomething().
public class Main {
    public static void main(String[] args) {
        try {
            doSomething();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * только checked исключения
     */
    public static void doSomething() throws Exception {
        throw new Exception();
    }
}
