//package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;


public class DinnerConstructor {
    HashMap<String, ArrayList<String>> menu; // ключ - это тип блюд, а список названия блюд этого типа

   // Random random = new Random ();

    DinnerConstructor() {
        menu = new HashMap<>();
      //  combos = new HashMap<>();
    }

    void newDishInMap(String dishName, String dishType, String newDish) {
        if (menu.containsKey((dishType))) {
            ArrayList<String> dishes = menu.get(dishType);
            dishes.add(dishName);
            dishes.add(newDish);
            menu.put(dishType, dishes);
        } else {
            ArrayList<String> newDishes = new ArrayList<>();
            newDishes.add(dishName);
            newDishes.add(newDish);
            menu.put(dishType, newDishes);
        }
    }

    boolean checkType (int numberOfCombos, String nextItem) {
        for (int i=0; i<= numberOfCombos; i++) {
            ArrayList<String> dishTypesFromCostumer = new ArrayList<>();
            for (int j=0; j <= dishTypesFromCostumer.size(); j++) {
                if (nextItem.equals (menu.containsKey(dishTypesFromCostumer))) {
                    System.out.println(dishTypesFromCostumer);

                }
            }
        }
        return true;
    }

  /*  void getRandomCombination (int numberOfCombos, String nextItem, ArrayList<String> dishTypeWeGot) {


        ArrayList<String> dishNames = menu.get(dishType);
        index = random.nextInt(dishNames.size());
        dishNames.get(index);
        combos.put(dishTypeForRandom, dishNames);
        System.out.println(combos);

        }*/

    void printallFoodByTypes() {
        for (String dishType : menu.keySet()) {
            System.out.println(dishType);
            for (String dishes : menu.get(dishType)) {
                System.out.println(dishes);
            }
        }
    }
}



