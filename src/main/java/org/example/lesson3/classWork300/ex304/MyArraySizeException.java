package org.example.lesson3.classWork300.ex304;

public class MyArraySizeException extends RuntimeException {
    public MyArraySizeException(int row, int colum) {
        super("Массив должен быть 4х4, размер Вашего массива = " + row + "х" + colum);
    }

    public MyArraySizeException() {
        super("Массив должен быть 4х4");
    }
}
