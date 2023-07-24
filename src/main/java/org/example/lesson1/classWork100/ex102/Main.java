package org.example.lesson1.classWork100.ex102;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        ask(array);
    }

    public static int chek(int[] array, int a) {
        if (array == null) {
            return -3;
        }
        if (array.length < 2) {
            return -1;
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i] == a) {
                return i;
            }
        }
        return -2;
    }

    public static void ask(int[] array){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите искомый элемент: ");
        int n = scanner.nextInt();
        int asd = chek(array, n);
        if (asd == -1){
            System.out.println("Длинна массива меньше 2 элементов, сами посмотрите");
        } else if (asd == -2) {
            System.out.println("Этого элемента нет в массиве");
        } else if (asd == -3){
            System.out.println("Вместо массива NULL");
        } else {
            System.out.printf("Индекс элемента = %d", asd);
        }
    }
}