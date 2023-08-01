package org.example.lesson3.homeWork300;

import org.example.lesson3.homeWork300.exceptions.MyStringFormatSex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите данные (ФИО ДатаРождения НомерТелефона Пол):");
        List<String> arrayInput = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            arrayInput.add(null);
        }

        System.out.println("Введите ФИО:");
        String input = scanner.nextLine();
        String[] str = input.split(" ");

        String sex ;
        for (String s : str) {
            if (str.length == 1 && (s.contains("f") || s.contains("m"))) {
                sex = s;
                arrayInput.set(3, sex);
            } else {
                try {
                    throw new RuntimeException();
                } catch (RuntimeException e) {
                    try {
                        throw new MyStringFormatSex();
                    } catch (MyStringFormatSex ex) {
                        System.out.println(ex.getMessage());
                    }
                }
            }

        }
        for (String strings : arrayInput) {
            System.out.println(Arrays.toString(new String[]{strings}));
        }
    }
}
