package hw3;

import java.util.ArrayList;
import java.util.Collections;


public class Box<T extends Fruit> {
    private final ArrayList<T> fruits = new ArrayList<>();

    public Box(T... fruits) {
        Collections.addAll(this.fruits, fruits);
    }

    // Получить вес коробки...
    public float getWeight() {
        int totalWeight = 0;
        for (T fruit : this.fruits) {
            totalWeight += fruit.getWeight();
        }

        return totalWeight;
    }

    // Получить кол-во фруктов...
    public int getSize() {
        return this.fruits.size();
    }

    // Добавить фрукт...
    public void setFruit(T fruit) {
        this.fruits.add(fruit);
    }

    // Выложить фрукты из текущей коробки в целевую...
    public void moveAt(Box<T> box) {
        box.fruits.addAll(this.fruits);
        this.fruits.clear();
    }

    // Сравнение весов коробок...
    public boolean compare(Box<? extends Fruit> box) {
        return box.getWeight() == this.getWeight();
    }
}