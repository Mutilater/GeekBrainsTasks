package JavaLevel2.Lesson02.task01;

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        String[][] startArray = {
                {"1", "2", "3", "4"},
                {"4", "3", "2", "1"},
                {"5", "6", "7", "8"},
                {"9", "234", "234", "12"},
        };
        ArrayList<String> errors = new ArrayList<>();
        int sum = 0;
        try {
            sum = Solution.arraySum(startArray);
        } catch (Exception e) {
            errors.add(e.toString());
        }
        if (errors.isEmpty()) {
            System.out.println("Сумма элементов массива: " + Integer.toString(sum));
        } else {
            for (String el : errors) {
                System.out.println("Невозможно вычислить сумму. Список ошибок: ");
                System.out.println(el);
            }
        }
    }

    /**
     *
     * @param array Input array of 4 by 4 dimensions
     * @return int Returns the sum of array elements
     * @throws MyArraySizeException|MyArrayDataException
     */
    private static int arraySum(String[][] array) throws Exception {
        if (array.length == 4) {
            for (String[] element : array) {
                if (element.length !=4) {
                    throw new MyArraySizeException("Ошибка! Неверная размерность массива.");
                }
            }
        }
        else {
            throw new MyArraySizeException("Ошибка! Неверная размерность массива.");
        }

        int sum = 0;
        for (int i = 0; i < 4 ; i++) {
            for (int j = 0; j < 4 ; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException  e) {
                    throw new MyArrayDataException("Ошибка! ", i, j);
                }

            }
        }
        return sum;
    }
}

class MyArraySizeException extends Exception {
    MyArraySizeException(String message) {
        super(message);
    }
}

class MyArrayDataException extends Exception {
    private int N;
    private int M;

    MyArrayDataException(String message, int n, int m) {
        super(message);
        N = n+1;
        M = m+1;
    }

    @Override
    public String toString() {
        return super.toString()+"В ячейке ["+ N +"," + M +"] неверные данные.";
    }
}