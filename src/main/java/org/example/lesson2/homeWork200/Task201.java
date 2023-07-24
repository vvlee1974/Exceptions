package org.example.lesson2.homeWork200;

import java.util.Scanner;

// Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float),
// и возвращает введенное значение. Ввод текста вместо числа не должно приводить к падению приложения,
// вместо этого, необходимо повторно запросить у пользователя ввод данных.
public class Task201 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите дробное число: ");
        String str = scanner.nextLine();
        getFloatNumber(str);
    }

    private static void getFloatNumber(String str) {
        try {
            float result = Float.parseFloat(str);
            System.out.println("Вывод: " + result);
        } catch (NumberFormatException e) {
            System.out.println("Введено не дробное число. Повторите ввод.");
        }
    }
}