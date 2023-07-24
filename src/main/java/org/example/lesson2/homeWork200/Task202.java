package org.example.lesson2.homeWork200;

public class Task202 {
    public static void main(String[] args) {
        try {
            int[] intArray = {1, 2, 3, 4, 5, 6, 7, 8, 9}; // Добавить начальный массив
            int d = 0;
            double catchedRes1 = (double) intArray[8] / d; // каст элемента массива
//            System.out.println("catchedRes1 = " + catchedRes1);
        } catch (ArithmeticException e) {
            System.out.println("divided from zero" + e);
        }
    }
}
