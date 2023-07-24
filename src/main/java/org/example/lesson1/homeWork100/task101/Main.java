package org.example.lesson1.homeWork100.task101;
import java.util.Arrays;

class Answer {
    public static void arrayOutOfBoundsException() {
        // Напишите свое решение ниже
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        System.out.println("array[8] = " + array[8]);
    }

    public static void divisionByZero() {
        // Напишите свое решение ниже
        int number = 5;
        int div = number / (number - 5);
        System.out.println("div = " + div);
    }

    public static void numberFormatException() {
        // Напишите свое решение ниже
        String str = "25 15 54 35 12";
        String[] s = str.split(" ");
        int[] result = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            result[i] = Integer.parseInt(s[i]);
        }
        System.out.println("Arrays.toString(result) = " + Arrays.toString(result));
    }
}

class Printer {
    public static void main(String[] args) {
        Answer ans = new Answer();
        try {
            ans.arrayOutOfBoundsException();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Выход за пределы массива");
        }

        try {
            ans.divisionByZero();
        } catch (ArithmeticException e) {
            System.out.println("Деление на ноль");
        }

        try {
            ans.numberFormatException();
        } catch (NumberFormatException e) {
            System.out.println("Ошибка преобразования строки в число");
        }
    }
}