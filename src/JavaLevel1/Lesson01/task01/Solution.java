package JavaLevel1.Lesson01.task01;

//TODO 1. Создать пустой проект в IntelliJ IDEA и прописать метод main();

public class Solution {
    public static void main(String[] args) {
        //TODO 2. Создать переменные всех пройденных типов данных, и инициализировать их значения;
        boolean condition = true;
        char letter = Character.MAX_VALUE;
        byte b = Byte.MAX_VALUE;
        short s = Short.MAX_VALUE;
        int i = Integer.MAX_VALUE;
        long l = Long.MAX_VALUE;
        float f = Float.MAX_VALUE;
        double d = Double.MAX_VALUE;

        System.out.println("Перечень високосных лет начиная с 1800 по 2400 годы н.э.:");
        for (int j = 1800; j <2400 ; j++) {
            if (checkYear(j)) System.out.println(j);
        }

    }

    /** 3. Написать метод вычисляющий выражение a * (b + (c / d)) и возвращающий результат,
     * где a, b, c, d – входные параметры этого метода;
     * @param a
     * @param b
     * @param c
     * @param d
     * @return
     */
    public static double calculate(int a, int b , int c, int d) {
        return a*(b+(double)c/d);
    }

    /** 4. Написать метод, принимающий на вход два числа, и проверяющий, что их сумма лежит в
     *  пределах от 10 до 20(включительно), если да – вернуть true, в противном случае – false;
     * @param a
     * @param b
     * @return
     */
    public static boolean check (int a, int b) {
        int s = a + b;
        if ((s >= 10 ) && (s <= 20)) return true;

        return false;
    }

    /** 5. Написать метод, которому в качестве параметра передается целое число, метод должен
     *  напечатать в консоль положительное ли число передали, или отрицательное; Замечание: ноль
     *  считаем положительным числом.
     * @param number
     */
    public static void printNumner(int number) {
        if (number < 0)
            System.out.println("Число " + number + " отрицательное");
        else System.out.println("Число " + number + " положительное");
    }
//

    /** 6. Написать метод, которому в качестве параметра передается целое число, метод должен
     *  вернуть true, если число отрицательное;     *
     * @param number
     * @return
     */
    public static boolean trueIfNegative(int number) {
        if(number<0) return true;
        return false;
    }

    /**   7. Написать метод, которому в качестве параметра передается строка, обозначающая имя,
     *    метод должен вывести в консоль сообщение «Привет, указанное_имя!»;
     * @param name
     */
    public static void printName(String name) {
        System.out.println("Привет, " + name);
    }

    /** 8. * Написать метод, который определяет является ли год високосным, и выводит сообщение в консоль.
     *  Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.
     * @param year
     * @return  true  - если год является високосный
     *          false - если год не является високосным
     */
    public static boolean checkYear(int year) {
        if ((year % 4 != 0) || ((year % 100 == 0) && (year % 400 != 0))) {
            return false;
        }
        return true;
    }
}

