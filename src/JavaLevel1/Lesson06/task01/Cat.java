package JavaLevel1.Lesson06.task01;

import java.util.Random;

public class Cat extends Animal {
    static final double MAX_RUN_DISTANCE = 200;
    static final double MAX_SWIM_DISTANCE = 0;
    static final double MAX_JUMP_HEIGHT = 2;

    private double runDistance;
    private double swimDistance;
    private double jumpHeight;
    private String name;

    public Cat(String name) {
        this.name = name;
        Random random = new Random();
        runDistance    = random.nextDouble()   *   MAX_RUN_DISTANCE;
        swimDistance   = random.nextDouble()   *   MAX_SWIM_DISTANCE;
        jumpHeight     = random.nextDouble()   *   MAX_JUMP_HEIGHT;
    }

    @Override
    boolean run(double distance) {
        if ((distance > 0) && (distance <= runDistance)) {
            System.out.println(name + ": run : true");
            return true;
        }
        System.out.println(name + ": run : false");
        return false;
    }

    @Override
    boolean swim(double distance) {
        if ((distance > 0) && (distance <= swimDistance)) {
            System.out.println(name + ": swim : true");
            return true;
        }
        System.out.println(name + ": swim : false");
        return false;
    }

    @Override
    boolean jump(double height) {
        if ((height > 0) && (height <= jumpHeight)) {
            System.out.println(name + ": jump : true");
            return true;
        }
        System.out.println(name + ": jump : false");
        return false;
    }
    @Override
    public String toString() {
        return "Кошка {" +
                "Имя = " + name +
                ", Дистанция бега = " + runDistance +
                ", Дистанция плавания = " + swimDistance +
                ", Высота прыжка = " + jumpHeight  +
                '}';
    }
}
