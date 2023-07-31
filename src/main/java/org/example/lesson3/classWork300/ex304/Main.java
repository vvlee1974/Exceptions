package org.example.lesson3.classWork300.ex304;


// 1. Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4.
// При подаче массива другого размера необходимо бросить исключение MyArraySizeException.

// 2. Далее метод должен пройтись по всем элементам массива, преобразовать в int и просуммировать.
// Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит символ или текст вместо числа),
// должно быть брошено исключение MyArrayDataException с детализацией, в какой именно ячейке лежат неверные данные.

// 3. В методе main() вызвать полученный метод,
// обработать возможные исключения MyArraySizeException и MyArrayDataException
// и вывести результат расчета (сумму элементов, при условии, что подали на вход корректный массив).
public class Main {
    public static void main(String[] args) {
        String[][] str = new String[4][4];
        int sum = 0;
        for (int i = 0; i < str[0].length; i++) {
            for (int j = 0; j < str[1].length; j++) {
                try {
                    sum += Integer.parseInt(str[i][j]);
                    System.out.println(sum);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException();
                }
            }
        }
    }
}

class MyArrayDataException extends NumberFormatException {
    public MyArrayDataException() {
        super("В массиве не число.");
    }
}


