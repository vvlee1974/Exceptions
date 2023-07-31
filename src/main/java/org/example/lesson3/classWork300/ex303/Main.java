package org.example.lesson3.classWork300.ex303;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

// 1. Создайте класс исключения, который будет выбрасываться при делении на 0.
// Исключение должно отображать понятное для пользователя сообщение об ошибке.
// 2. Создайте класс исключений, которое будет возникать при обращении к пустому элементу в массиве ссылочного типа.
// Исключение должно отображать понятное для пользователя сообщение об ошибке.
// 3. Создайте класс исключения, которое будет возникать при попытке открыть несуществующий файл.
// Исключение должно отображать понятное для пользователя сообщение об ошибке.
public class Main {
    public static void main(String[] args) throws NotFile {
        try {
            int a = 5 / 0;
        } catch (ArithmeticException e) {
            try {
                throw new DivByZero();
            } catch (DivByZero ex) {
                System.out.println(ex.getMessage());
            }
        }

        int i = 0;
        try {
            Integer[] array = {1, 2, 3, 4, null, 6, 7, 8, 9, 0};
            for (; i < array.length; i++) {
                System.out.println(array[i]);
                array[i]++;
            }
        } catch (NullPointerException e) {
            try {
                throw new NullPointerArray(i);
            } catch (NullPointerArray ex) {
                System.out.println(ex.getMessage());
            }
        }

        String path = "sdfrss.txt";
        try (FileReader fr = new FileReader(path)) {
            int a = 5;
        } catch (FileNotFoundException e) {
            try {
                throw new NotFile(path);
            }catch (NotFile ex){
                System.out.println(ex.getMessage());
            }
        } catch (IOException e) {
            e.getMessage();
        }
    }
}
