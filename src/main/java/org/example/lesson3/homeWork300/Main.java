package org.example.lesson3.homeWork300;

import org.example.lesson3.homeWork300.exceptions.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Приложение должно проверить введенные данные по количеству.
// Если количество не совпадает с требуемым, вернуть код ошибки, обработать его и показать пользователю сообщение,
// что он ввел меньше и больше данных, чем требуется.

public class Main {
    public static void main(String[] args) throws IOException {
        List<String> arrayInput = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            arrayInput.add(null);
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите данные (ФИО ДатаРождения НомерТелефона Пол):");

        System.out.println("Введите ФИО:");
        String input = scanner.nextLine();
        checkStringEmpty(input);
        String checkInput = getFullName(input);
        String[] strings = checkInput.split(" ");
        int i = 0;
        for (String string : strings) {
            arrayInput.set(i, string);
            i++;
        }

        System.out.println("Введите Дату рождения (дд/мм/гггг):");
        String input1 = scanner.nextLine();
        checkStringEmpty(input1);
        arrayInput.set(3, getDate(input1));

        System.out.println("Введите Номер телефона:");
        String input2 = scanner.nextLine();
        checkStringEmpty(input2);
        arrayInput.set(4, getPhoneNumber(input2));

        System.out.println("Введите Пол (f/m):");
        String input3 = scanner.nextLine();
        checkStringEmpty(input3);
        arrayInput.set(5, getInfoSex(input3));

        for (String str : arrayInput) {
            System.out.print(Arrays.toString(new String[]{str}));
        }
        String path = "C:\\Users\\vvlee\\Моя учёба_GeekBrans\\Exceptions\\Seminars\\src\\main\\java\\org\\example\\lesson3\\homeWork300\\data\\";
        saveRecord(arrayInput, path);

    }

    private static void saveRecord(List<String> arrayInput, String path) {

        StringBuilder result = new StringBuilder();
        for (String s : arrayInput) {
            result.append(s).append("\t");
        }
        try {
            Files.write(Paths.get(path + arrayInput.get(0) + ".txt"), result.toString().getBytes());
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private static void checkStringEmpty(String input) {
        if (input.isEmpty()) {
            try {
                throw new RuntimeException();
            } catch (RuntimeException e) {
                try {
                    throw new MyStringEmpty();
                } catch (MyStringEmpty ex) {
                    System.out.println(ex.getMessage());
                    System.exit(0);
                }
            }
        }
    }

    private static String getPhoneNumber(String input2) {
        String result = "НомерТелефона";
        String regex = "^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input2);
        if (matcher.find()) {
            result = matcher.group();
            return result;
        } else {
            try {
                throw new RuntimeException();
            } catch (RuntimeException e) {
                try {
                    throw new MyPhoneNumberFormatException();
                } catch (MyPhoneNumberFormatException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
        return result;
    }

    private static String getDate(String input1) {
        String allMatches = "ДатаРождения";
        Matcher m = Pattern.compile("(0[1-9]|[12][0-9]|3[01])[\\- /.](0[1-9]|1[012])[\\- /.](19|20)\\d\\d").matcher(input1);

        if (m.find()) {
            allMatches = m.group();
            return allMatches;
        } else {
            try {
                throw new RuntimeException();
            } catch (RuntimeException e) {
                try {
                    throw new MyNumberFormatException();
                } catch (MyNumberFormatException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
        return allMatches;
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
                    input = "ФИО";
                }
            }
        }
        return input;
    }

    private static String getInfoSex(String input3) {
        String[] str3 = input3.split(" ");
        String sex = "Пол";
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
                    }
                }
            }
        }
        return sex;
    }
}