package JavaLevel1.Lesson02.task01;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        // 1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
        //  С помощью цикла и условия заменить 0 на 1, 1 на 0;
        int[] a1 = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        System.out.println("Задача 1.");
        System.out.println("Исходный массив:       " + Arrays.toString(a1));
        for (int i = 0; i < a1.length ; i++) {
            a1[i] = (a1[i] == 0) ? 1 : 0;
        }
        System.out.println("Результирующий массив: " + Arrays.toString(a1));

        //2. Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
        int[] a2 = new int[8];
        for (int i = 0; i <a2.length ; i++) {
            a2[i] = i*3;
        }
        System.out.println("====================================================");
        System.out.println("Задача 2. " + Arrays.toString(a2));
        //3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
        int a3[] = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println("====================================================");
        System.out.println("Задача 3.");
        System.out.println("Исходный массив:       " + Arrays.toString(a3));
        for(int x : a3) {
            if (x<6) x*=2;
            //x = (x<6) ? x*2: x;
        }
        System.out.println("Результирующий массив: " + Arrays.toString(a3));
        //4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое), и с помощью
        // цикла(-ов) заполнить его диагональные элементы единицами;
        int N = 5;
        int a4[][] = new int [N][N];
        for (int i = 0; i < N ; i++) {
            a4[i][i] = 1;
            a4[i][N-i-1] = 1;
        }
        System.out.println("====================================================");
        System.out.println("Задача 4. Заполнение диагоналей матрицы единицами.");

        for (int i = 0; i < N ; i++) {
            System.out.print("Строка " + (i+1) + ":     ");
            for (int j = 0; j < N; j++) {
                System.out.print(a4[i][j] + " ");
            }
            System.out.println();
        }

        //5. ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
        //Чтобы не объявлять массив заново, возьмем массив из Задачи 3.
        int min = a3[0],
            max = a3[0],
            imin = 0,
            imax = 0;

        for (int i = 0; i < a3.length; i++) {
            if (min>a3[i]) {
                min = a3[i];
                imin = i;
            }
            if (max<a3[i]) {
                max = a3[i];
                imax = i;
            }
        }
        System.out.println("====================================================");
        System.out.println("Задача 5.");
        System.out.println("Исходный массив: " + Arrays.toString(a3));
        System.out.println("MINимальный элемент в массиве a["+imin+"] = " + min);
        System.out.println("MAXимальный элемент в массиве a["+imax+"] = " + max);
        System.out.println("====================================================");


        System.out.println("Задача 6.");
        int a6_1[] = {1, 1, 1, 2, 1};
        System.out.println("checkBalance([1, 1, 1, || 2, 1]) → " + checkBalance(a6_1));
        int a6_2[] = {2, 1, 1, 2, 1};
        System.out.println("checkBalance ([2, 1, 1, 2, 1]) → " + checkBalance(a6_2));
        int a6_3[] = {10, 10};
        System.out.println("checkBalance ([10, || 10]) → " + checkBalance(a6_3));
        System.out.println("====================================================");

        System.out.println("Задача 7.");
        int a7_1[] = {1, 2, 3, 4, 5, 6,7,8,9};
        String s = Arrays.toString(a7_1);
        arrayShift(a7_1, -3);
        System.out.println("arrayShift(a7_1, -3) :" + s + " → " + Arrays.toString(a7_1));
        int a7_2[] = {1, 2, 3, 4, 5, 6,7,8,9};
        s = Arrays.toString(a7_2);
        arrayShift(a7_2, 3);
        System.out.println("arrayShift(a7_2, 3)  :" + s + " → " + Arrays.toString(a7_2));
    }

    /**
     * 6. ** Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true,
     * если в массиве есть место, в котором сумма левой и правой части массива равны.
     * Примеры:
     * checkBalance([1, 1, 1, || 2, 1]) → true,
     * checkBalance ([2, 1, 1, 2, 1]) → false,
     * checkBalance ([10, || 10]) → true, граница показана символами ||, эти символы в массив не входят.
     *
     * @param a
     * @return
     */
    public static boolean checkBalance(int[] a) {
        int sumLeft = 0, sumRight = 0;
        for (int i = 0; i < a.length ; i++) sumRight += a[i];
        for (int i = 0; i < a.length; i++) {
            sumLeft+=a[i];
            sumRight-=a[i];
            if (sumLeft>sumRight) return false;
            else if(sumLeft == sumRight) return true;
        }
        return false;
    }
    /**
     * 7. **** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным,
     * или отрицательным), при этом метод должен сместить все элементымассива на n позиций. Для усложнения задачи
     * нельзя пользоваться вспомогательными массивами.
     *
     * @param a
     * @param n
     */

    public static void arrayShift(int a[], int n) {
        if (Math.abs(n) >= a.length) return;
        if ( n > 0) {
            for (int i = 0; i < n; i++) {
                int iNext = i + n, valuePrev = a[i], buf;
                a[i] = 0;
                while (iNext < a.length) {
                    buf = a[iNext];
                    a[iNext] = valuePrev;
                    valuePrev = buf;
                    iNext += n;
                }
            }
        } else if (n < 0) {
            for (int i = a.length - 1 ; i > a.length-1 + n; i--) {
                int iNext = i + n, valuePrev = a[i], buf;
                a[i] = 0;
                while (iNext >= 0) {
                    buf = a[iNext];
                    a[iNext] = valuePrev;
                    valuePrev = buf;
                    iNext += n;
                }
            }
        }
    }
}
