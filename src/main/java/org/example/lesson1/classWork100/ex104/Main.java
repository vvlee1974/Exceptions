package org.example.lesson1.classWork100.ex104;
// Реализуйте метод checkArray(Integer[] arr), принимающий в качестве аргумента целочисленный одномерный массив.
// Метод должен пройтись по каждому элементу и проверить что он не равен null.
// А теперь реализуйте следующую логику:
// Если в какой-то ячейке встретился null, то необходимо “оповестить” об этом пользователя
// Если null’ы встретились в нескольких ячейках, то идеально было бы все их “подсветить”

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Integer[] array = {3, null, 5, 6, null};
        checkArray(array);
    }

    public static void checkArray(Integer[] arr) {
        ArrayList<Integer> errors = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == null) errors.add(i);
        }
        if (!errors.isEmpty()) {
            throw new RuntimeException("Индексы элементов не имеющих ссылки: " + errors);
        }
    }
}