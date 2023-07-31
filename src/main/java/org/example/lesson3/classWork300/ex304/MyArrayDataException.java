package org.example.lesson3.classWork300.ex304;

class MyArrayDataException extends NumberFormatException {
    public MyArrayDataException() {
        super("В каком-то элементе массива преобразование не удалось.");
    }

    public MyArrayDataException(int i, int j) {
        super("Преобразование не удалось, индексы = " + i + ":" + j);
    }
}
