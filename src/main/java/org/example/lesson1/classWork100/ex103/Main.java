package org.example.lesson1.classWork100.ex103;

public class Main {
    public static void main(String[] args) {
        //int[][] array = {{3, 2}, {4, 5}};
        int[][] array = {{3, 2, 4}, {4, 5}};
        //int[][] array = {{0, 1}, {1, 0}};

        System.out.println(sumElement(array));
    }


    public static int sumElement (int[][] array) {
        int sum = 0;

        if (array[0].length != array.length)
            throw new RuntimeException("Массив не является квадратным");

        for (int i=0; i < array.length; i++)
            for (int j=0; j < array[0].length; j++){
                if ( (array[i][j] != 0 && array[i][j] != 1))
                    throw new RuntimeException("Элемент массива не 0/1");
                sum += array[i][j];
            }

        return sum;
    }


//    public static int arraySum(int[][] array){
//        int sum = 0;
//        if (array.length != array[0].length) throw new RuntimeException("Массив не квадратный");
//        else {
//            for (int i = 0; i < array.length; i++) {
//                for (int j = 0; j < array.length; j++) {
//                    if (array[i][j] == 0 || array[i][j] == 1) sum = sum + array[i][j];
//                    else throw new RuntimeException("Массив состоит не из нулей и единиц");
//                }
//            }
//        }
//        return sum;
//    }
}
