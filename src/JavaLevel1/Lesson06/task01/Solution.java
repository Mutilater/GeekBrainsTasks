package JavaLevel1.Lesson06.task01;

public class Solution {
    public static void main(String[] args) {
        Dog dog1 = new Dog("Шарик");
        Dog dog2 = new Dog("Бобик");
        Cat cat1 = new Cat("Барсик");
        Cat cat2 = new Cat("Мурзик");

        System.out.println(dog1);
        System.out.println(dog2);
        System.out.println(cat1);
        System.out.println(cat2);
        dog1.run(500);
        dog2.run(300);
        dog1.jump(0.2);
        cat1.swim(4);
        cat2.run(50);
    }
}
