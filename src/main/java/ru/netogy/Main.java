package ru.netogy;

public class Main {
    public static void main(String[] args) {

        Person parent = new PersonBuilder()
                .setName("Иван")
                .setSurname("Петров")
                .setAge(35)
                .setAddress("Москва")
                .build();

        System.out.println("Родитель: " + parent);


        Person child = parent.newChildBuilder()
                .setName("Петр")
                .build();

        System.out.println("Ребенок: " + child);


        try {
            new PersonBuilder()
                    .setAge(25)
                    .build();
        } catch (IllegalStateException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }


        try {
            new PersonBuilder()
                    .setName("Анна")
                    .setSurname("Иванова")
                    .setAge(-10)
                    .build();
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}