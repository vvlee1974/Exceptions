package org.example.lesson3.homeWork300.view;

import org.example.lesson3.homeWork300.exceptions.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class View {
    public View() {
    }

    public void run() {
        List<String> arrayInput = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            arrayInput.add(null);
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("----------------------------------------------------------------");
        System.out.println("Введите 4 вида данных:");
        System.out.println("----------------------");
        System.out.println("ФИО (Фамилия Имя Отчество)");
        System.out.println("ДатаРождения (dd.mm.yyyy)");
        System.out.println("НомерТелефона (+7-xxx-xxx-xx-xx)");
        System.out.println("Пол (m / f)");
        System.out.println("----------------------------------------------------------------");
        int n = 1;
        while (n <= 4) {
            System.out.println("Введите параметр № " + n + ":");
            String input = scanner.nextLine();
            checkStringEmpty(input);
            String checkInput = getFullName(input);
            String checkInput2 = getDate(input);
            String checkInput3 = getPhoneNumber(input);
            String checkInput4 = getInfoSex(input);

            if (checkInput != null) {
                System.out.println("Это - ФИО.");
                System.out.println("_______________________________");
                try {
                    String[] strings = checkInput.split(" ");
                    int i = 0;
                    for (String string : strings) {
                        arrayInput.set(i, string);
                        i++;
                    }
                } catch (NullPointerException e) {
                    try {
                        throw new MyNullPointerEx();
                    } catch (MyNullPointerEx ex) {
                        System.out.println(ex.getMessage());
                    }
                }
            }
            if (checkInput2 != null) {
                System.out.println("Это - ДатаРождения.");
                System.out.println("_______________________________");
                arrayInput.set(3, checkInput2);
            }
            if (checkInput3 != null) {
                System.out.println("Это - НомерТелефона.");
                System.out.println("_______________________________");
                arrayInput.set(4, checkInput3);
            }
            if (checkInput4 != null) {
                System.out.println("Это - Пол.");
                System.out.println("_______________________________");
                arrayInput.set(5, checkInput4);
            }
            n++;
        }
        System.out.println();
        System.out.println("_______________________________");
        System.out.println("Текущая запись:");
        for (String str : arrayInput) {
            System.out.print(Arrays.toString(new String[]{str}));
        }
        System.out.println();
        System.out.println("_______________________________");
        System.out.println("1 - Добавить запись");
        System.out.println("2 - Начать заново");
        System.out.println("_______________________________");
        int choice = scanner.nextInt();
        String path = "C:\\Users\\vvlee\\Моя учёба_GeekBrans\\Exceptions\\Seminars\\src\\main\\java\\org\\example\\lesson3\\homeWork300\\data\\";
        if (choice <= 2 && choice > 0) {
            switch (choice) {
                case 1 -> {
                    searchFile(arrayInput, path);
                    System.out.println("Запись добавлена");
                }
                case 2 -> {
                    System.out.println("Повторите ввод данных.");
                    System.exit(0);
                }
            }
        } else System.out.println("Некорректный ввод. Повторите выбор.");
        scanner.close();
    }

    private static void searchFile(List<String> arrayInput, String path) {
        File[] list;
        File filesPath = new java.io.File(path);
        list = filesPath.listFiles();
        if (list != null && list.length == 0) {
            saveRecord(arrayInput, path);
        } else {
            assert list != null;
            for (File file : list) {
                String buf = file.getName();
                if (buf.equals(arrayInput.get(0))) {
                    StringBuilder result1 = new StringBuilder();
                    for (String s : arrayInput) {
                        result1.append(s);
                    }
                    try (FileWriter writer = new FileWriter(path + arrayInput.get(0) + ".txt", true)) {
                        writer.write(result1.toString());
                        writer.append('\n');
                        writer.flush();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    saveRecord(arrayInput, path);
                    break;
                }
            }
        }
        System.out.println("list = " + Arrays.toString(new int[]{list.length}));
    }

    private static void saveRecord(List<String> arrayInput, String path) {
        StringBuilder result = new StringBuilder();
        for (String s : arrayInput) {
            result.append(s).append("\t");
        }
        try (FileWriter writer = new FileWriter(path + arrayInput.get(0) + ".txt", true)) {
            writer.write(result.toString());
            writer.append('\n');
            writer.flush();
        } catch (IOException e) {
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
        String result;
        String regex = "^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input2);
        if (matcher.find() && input2.length() > 10) {
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
        return null;
    }

    private static String getDate(String input1) {
        String allMatches;
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
        return null;
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
                }
            }
        }
        return null;
    }

    private static String getInfoSex(String input3) {
        String[] str3 = input3.split(" ");
        String sex;
        for (String s : str3) {
            if (str3.length == 1 && (s.equals("f") || s.equals("m"))) {
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
        return null;
    }
}