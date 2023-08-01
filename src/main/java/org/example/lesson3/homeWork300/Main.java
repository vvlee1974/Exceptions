package org.example.lesson3.homeWork300;

import org.example.lesson3.homeWork300.exceptions.MyStringFormatName;
import org.example.lesson3.homeWork300.exceptions.MyStringFormatSex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<String> arrayInput = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            arrayInput.add(null);
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите данные (ФИО ДатаРождения НомерТелефона Пол):");

        System.out.println("Введите ФИО:");
        String input = scanner.nextLine();
        arrayInput.set(0, getFullName(input));

        System.out.println("Введите Пол (f/m):");
        String input3 = scanner.nextLine();
        arrayInput.set(3, getInfoSex(input3));


        for (String strings : arrayInput) {
            System.out.println(Arrays.toString(new String[]{strings}));
        }
    }

    private static String getFullName(String string) {
        String input = string.trim().replaceAll("\\s+", " ");
        String[] str = input.split(" ");

        if (str.length == 3) {
            return input;
        } else {
            try {
                throw new RuntimeException();
            } catch (RuntimeException e) {
                try {
                    throw new MyStringFormatName();
                } catch (MyStringFormatName ex) {
                    System.out.println(ex.getMessage());
                    System.exit(0);
                }
            }
        }
        return null;
    }

    private static String getInfoSex(String input3) {
        String[] str3 = input3.split(" ");
        String sex;
        for (String s : str3) {
            if (str3.length == 1 && (s.contains("f") || s.contains("m"))) {
                sex = s;
                return sex;
            } else {
                try {
                    throw new RuntimeException();
                } catch (RuntimeException e) {
                    try {
                        throw new MyStringFormatSex();
                    } catch (MyStringFormatSex ex) {
                        System.out.println(ex.getMessage());
                        System.exit(0);
                    }
                }
            }
        }
        return null;
    }
}
