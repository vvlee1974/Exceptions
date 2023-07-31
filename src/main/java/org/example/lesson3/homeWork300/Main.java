package org.example.lesson3.homeWork300;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите данные (ФИО ДатаРождения НомерТелефона Пол) через пробел:");
        String input = scanner.nextLine();
        String[] arrayInput = input.split(" ");

    }
}
