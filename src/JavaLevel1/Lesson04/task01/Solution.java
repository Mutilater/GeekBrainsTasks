package JavaLevel1.Lesson04.task01;

import java.util.Random;
import java.util.Scanner;

    public class Solution {
        public static int SIZE = 3;         // Размерность игрового поля по умолчанию.
        public static int DOTS_TO_WIN = 3;  // Количество точек для победы по умолчанию.
        public static final char DOT_EMPTY = '•';
        public static final char DOT_X = 'X';
        public static final char DOT_O = 'O';
        public static char[][] map;
        public static Scanner sc = new Scanner(System.in);
        public static Random rand = new Random();
        public static void main(String[] args) {
            int buf;
            System.out.println("Введите размерность игрового поля:");
            while(true) {
                buf = sc.nextInt();
                if (buf > 2) {
                    SIZE = buf;
                    System.out.println("Создано игровое поле размерностью (" + SIZE + " x " + SIZE + ")");
                    break;
                }
                System.out.println("Игровое поле должно иметь размерность больше  (2 х 2)!");
                System.out.println("Повторите ввод: ");
            }
            System.out.println("Введите количество точек для победы");
            while (true) {
                buf = sc.nextInt();
                if (buf <= SIZE) {
                    DOTS_TO_WIN = buf;
                    System.out.println("Для победы необходимо выстроить " + DOTS_TO_WIN + " точек в ряд");
                    break;
                }
                System.out.println("Необходимое количество точек для победы не должно превышать размерность игрового поля.");
                System.out.println("Повторите ввод: ");

            }
            initMap();
            printMap();
            while (true) {
                humanTurn();
                printMap();
                if (checkWin(DOT_X)) {
                    System.out.println("Победил человек");
                    break;
                }
                if (isMapFull()) {
                    System.out.println("Ничья");                    break;

                }
                aiTurn();
                printMap();
                if (checkWin(DOT_O)) {
                    System.out.println("Победил Искуственный Интеллект");
                    break;
                }
                if (isMapFull()) {
                    System.out.println("Ничья");
                    break;
                }
            }
            System.out.println("Игра закончена");
        }
        public static boolean checkWin(char symb) {
            boolean resultX = true;
            boolean resultY = true;
            boolean resultMainDiag = true;
            boolean resultSecDiag = true;

            for (int N = 0; N < SIZE - DOTS_TO_WIN+1; N++) {
                for (int M = 0; M < SIZE - DOTS_TO_WIN+1; M++) {

                    for (int i = N; i < N + DOTS_TO_WIN; i++) {
                        for (int j = M; j < M + DOTS_TO_WIN ; j++) {
                            resultX = resultX && (map[i][j] == symb);
                            resultY = resultY && (map[j][i] == symb);
                            if ((i - N) == (j - M)) {
                                resultMainDiag = resultMainDiag && (map[i][j] == symb);
                            }
                            if ((j - M)  == (DOTS_TO_WIN - (i - N) - 1)) {
                                resultSecDiag = resultSecDiag && (map[i][j] == symb);
                            }
                        }
                        if (resultX || resultY) {
                            if (resultX) System.out.println("Победа по горизонтали");
                            if (resultY) System.out.println("Победа по вертикали");
                            return true;
                        } else {
                            resultX = true;
                            resultY = true;
                        }
                    }

                    if (resultMainDiag) System.out.println("Победа по главной диагонали \\");
                    if (resultSecDiag)  System.out.println("Победа по второстепенной диагонали /");

                    if (resultMainDiag || resultSecDiag) return true;
                    else {
                        resultMainDiag = true;
                        resultSecDiag = true;
                    }
                }
            }
            return false;
        }
        public static boolean isMapFull() {
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    if (map[i][j] == DOT_EMPTY) return false;
                }
            }
            return true;
        }
        public static void aiTurn() {
            int x, y;
            do {
                x = rand.nextInt(SIZE);
                y = rand.nextInt(SIZE);
            } while (!isCellValid(x, y));
            System.out.println("Компьютер походил в точку " + (x + 1) + " " + (y + 1));
            map[y][x] = DOT_O;
        }
        public static void humanTurn() {
            int x, y;
            do {
                System.out.println("Введите координаты в формате X Y");
                x = sc.nextInt() - 1;
                y = sc.nextInt() - 1;
            } while (!isCellValid(x, y)); // while(isCellValid(x, y) == false)
            map[y][x] = DOT_X;
        }
        public static boolean isCellValid(int x, int y) {
            if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) return false;
            if (map[y][x] == DOT_EMPTY) return true;
            return false;
        }
        public static void initMap() {
            map = new char[SIZE][SIZE];
            for (int i = 0; i < SIZE; i++) {

                for (int j = 0; j < SIZE; j++) {
                    map[i][j] = DOT_EMPTY;
                }
            }
        }
        public static void printMap() {
            for (int i = 0; i <= SIZE; i++) {
                System.out.print(i + " ");
            }
            System.out.println();
            for (int i = 0; i < SIZE; i++) {
                System.out.print((i + 1) + " ");
                for (int j = 0; j < SIZE; j++) {
                    System.out.print(map[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }