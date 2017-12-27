package JavaLevel1.Lesson07.task01;

import java.util.ArrayList;

class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }
    public boolean decreaseFood(int n) {
        if (food < n) {
            return false;
        }
        food -= n;
        return true;
    }
    public void info() {
        System.out.println("plate: " + food);
    }

    public void increaseFood(int amount) {
        System.out.println("Добавляем в тарелку " + amount + " едениц еды");
        food+=amount;
    }
}
class Cat {
    private String name;
    private int appetite;
    private boolean full = false;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    public boolean isFull() {
        return full;
    }

    public void eat(Plate p) {
        if (!p.decreaseFood(appetite))  {
            System.out.println("В тарелке недостаточно еды. Кот " + name + " голоден");
            this.full = false;
        }
        else {
            System.out.println("Кот " + name + " сыт");
            this.full = true;
        }
    }
}

public class Solution {
        public static void main(String[] args) {
            //Cat cat = new Cat("Barsik", 5);
            ArrayList<Cat> cats = new ArrayList<>();
            Plate plate = new Plate(100);
            plate.info();

            for (int i = 0; i < 20 ; i++) {
                cats.add(new Cat("Cat_"+Integer.toString(i+1), 5));
                cats.get(i).eat(plate);
            }
            cats.get(0).eat(plate);
            plate.increaseFood(100);
            cats.get(0).eat(plate);

        }
}
