package JavaLevel1.Lesson05.task01;

/**
 * Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст;
 * Конструктор класса должен заполнять эти поля при создании объекта;
 * Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль;
 * Создать массив из 5 сотрудников
 Пример:
 Person[] persArray = new Person[5]; // Вначале объявляем массив объектов
 persArray[0] = new Person("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 30000, 30); // потом для каждой ячейки массива задаем объект
 persArray[1] = new Person(...);
 ...
 persArray[4] = new Person(...);

 * С помощью цикла вывести информацию только о сотрудниках старше 40 лет;
 */
public class Solution {
    public static void main(String[] args) {
        Person[] persArray = new Person[5];
        persArray[0] = new Person("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 30000, 30);
        persArray[1] = new Person(
                "Sidorov Petr",
                "Doctor",
                "sidorovitch@live.com",
                "890355645",
                50000, 28);
        persArray[2] = new Person(
                "Putin Vladimir",
                "President",
                "putin@kremlin.ru",
                "top secret",
                300000, 60);
        persArray[3] = new Person(
                "Petrov Sidor",
                "Chief",
                "petrovitch@yahoo.com",
                "89123456",
                50000, 25);
        persArray[4] = new Person(
                " Darth Vader",
                "General of Army",
                "starofdeath@starwars.com",
                "999999999",
                1000000, 150);

        for(Person x: persArray) {
            if(x.age>=40) System.out.println(x);
        }
    }
}

class Person {
    String name;
    String position;
    String email;
    String phone;
    double salary;
    int age;

    public Person(String name, String position, String email, String phone, double salary, int age) {
        this.name = name;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Сотрудник{" +
                "ФИО ='" + name + '\'' +
                ", Должность ='" + position + '\'' +
                ", Email ='" + email + '\'' +
                ", Телефон =" + phone +
                ", Зарплата =" + salary +
                ", Возраст =" + age +
                '}';
    }
}