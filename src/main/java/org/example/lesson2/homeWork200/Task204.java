package org.example.lesson2.homeWork200;

import java.util.Scanner;

// Разработайте программу, которая выбросит Exception, когда пользователь вводит пустую строку.
// Пользователю должно показаться сообщение, что пустые строки вводить нельзя.
public class Task204 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите текст:");
        String message = scanner.nextLine();
        if (message == null || message.trim().isEmpty()){
            throw new RuntimeException("Пустая строка недопустима.");
        }else System.out.println("message = " + message);
    }
}
