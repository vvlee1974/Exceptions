package org.example.lesson2.homeWork200;

import java.util.Arrays;

public class Task203 {
    public static void main(String[] args) {
        try {
            Integer a = 27; // установить ссылочный тип данных
            Integer b = 3; // установить ссылочный тип данных
            System.out.println(a / b);
            printSum(23, 234);
            Integer[] abc = {1, 2}; // установить ссылочный тип данных
            System.out.println("abc = " + Arrays.toString(abc)); // добавить вывод
            abc[1] = 9;
            System.out.println("Новый abc = " + Arrays.toString(abc)); // добавить вывод
//        } catch (Throwable ex) { // Удалить класс высшего порядка для исключений
//            System.out.println("Что-то пошло не так...");
        } catch (NullPointerException ex) {
            System.out.println("Указатель не может указывать на null!");
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Массив выходит за пределы своего размера!");
        }
    }

    public static void printSum(Integer a, Integer b){ //throws FileNotFoundException {
        System.out.println(a + b);
    }
}