package JavaLevel1.Lesson03.task01;

import java.util.Random;
import java.util.Scanner;

/*
 2 * Создать массив из слов String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli",
                                                "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango",
                                                "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple",
                                                "pumpkin", "potato"};

 При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя, сравнивает его с загаданным словом
 и сообщает правильно ли ответил пользователь. Если слово не угадано, компьютер показывает буквы которые стоят на своих местах.
 НАПРИМЕР:
        apple – загаданное
        apricot - ответ игрока
        ap############# (15 символов, чтобы пользователь не мог узнать длину слова)
 Для сравнения двух слов посимвольно, можно пользоваться:
     String str = "apple";
     str.charAt(0); - метод, вернет char, который стоит в слове str на первой позиции
     Играем до тех пор, пока игрок не отгадает слово
     Используем только маленькие буквы
 */
public class Solution {
    public static void main(String[] args) {
        String[] words = {
                "apple", "orange", "lemon", "banana",
                "apricot", "avocado", "broccoli", "carrot",
                "cherry", "garlic", "grape", "melon",
                "leak", "kiwi", "mango", "mushroom",
                "nut", "olive", "pea", "peanut",
                "pear", "pepper", "pineapple", "pumpkin",
                "potato"
        };

        Scanner scanner = new Scanner(System.in);
        String myWord = words[new Random().nextInt(words.length - 1)]; //Рандомно выбираем слово из списка

        System.out.println("Привет! Я загадал слово ###############. Попробуйте отгадать=)");
        //System.out.println(myWord);
        int minLength;
        int counter = 0;
        while(true) {                           //Бесконечный цикл
            System.out.println("Попытка №" + (++counter) + " Введите слово:");
            String userWord = scanner.nextLine();

            if(myWord.equals(userWord)) break;  //Выход из цикла при совпадении.

            if (myWord.length() < userWord.length()) minLength = myWord.length();
            else minLength = userWord.length();

            for (int i = 0; i < minLength; i++) {
                if (myWord.charAt(i) == userWord.charAt(i)) System.out.print(myWord.charAt(i));
                else System.out.print('#');
            }
            for (int i = 0; i < 15 - minLength; i++) System.out.print("#");
            System.out.println();
        }
        System.out.println("УРРРРА! Вы верно угадали. Я загадал слово " + myWord + "!");
    }
}
