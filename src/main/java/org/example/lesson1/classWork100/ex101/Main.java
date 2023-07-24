package org.example.lesson1.classWork100.ex101;
// Реализуйте метод, принимающий в качестве аргумента целочисленный массив.
// Если длина массива меньше некоторого заданного минимума, метод возвращает -1,
// в качестве кода ошибки, иначе - длину массива.

public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 2 ,3, 4, 5};
        System.out.println(task1(arr, 10));
    }

    public static int task1(int[] arr, int min) {
        if (arr.length < min) {
            return -1;
        }
        return arr.length;
    }
}