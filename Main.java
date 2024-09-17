//package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Main {

    static DinnerConstructor dc;
    static Scanner scanner;
    static Random random = new Random ();
    static HashMap<Integer, ArrayList<String>> combos = new HashMap<>();

    public static void main(String[] args) {
        dc = new DinnerConstructor();
        scanner = new Scanner(System.in);
       combos=new HashMap<>();

        while (true) {
            printMenu();
            String command = scanner.nextLine();

            switch (command) {
                case "1":
                    addNewDish();
                    dc.printallFoodByTypes();
                    break;
                case "2":
                    generateDishCombo();
                    break;
                case "3":
                    return;
            }
        }
    }

    private static void printMenu() {
        System.out.println("Выберите команду:");
        System.out.println("1 - Добавить новое блюдо");
        System.out.println("2 - Сгенерировать комбинации блюд");
        System.out.println("3 - Выход");
    }

    private static void addNewDish() {
        System.out.println("Введите тип блюда:");
        String dishType = scanner.nextLine();
        System.out.println("Введите название блюда:");
        String dishName = scanner.nextLine();

        System.out.println ("Добавьте новое блюдо");
        String newDish = scanner.nextLine();

        dc.newDishInMap(dishName, dishType, newDish);

        dc.printallFoodByTypes();
        // добавьте новое блюдо
    }

    private static void generateDishCombo() {
        System.out.println("Начинаем конструировать обед...");

        System.out.println("Введите количество наборов, которые нужно сгенерировать:");
        int numberOfCombos = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Вводите типы блюда, разделяя символом переноса строки (enter). Для завершения ввода введите пустую строку");
        String nextItem = scanner.nextLine();


        ArrayList<String> dishTypeWeGot = new ArrayList<>();
        //реализуйте ввод типов блюд
        while (!nextItem.isEmpty()) {
            if (dc.checkType(numberOfCombos, nextItem)) {
                dishTypeWeGot.add(nextItem);
            } else {
                System.out.println("Такой категории блюд в нашем ресторане нету!" +
                        " Попробуйте еще раз.");
            }
            nextItem = scanner.nextLine();
        }
        int index = random.nextInt(dishTypeWeGot.size());
        dishTypeWeGot.get(index);
        combos.put(numberOfCombos, dishTypeWeGot);
        System.out.println(combos);
        //dc.getRandomCombination(numberOfCombos, nextItem);
        // сгенерируйте комбинации блюд и выведите на экран

    }
}