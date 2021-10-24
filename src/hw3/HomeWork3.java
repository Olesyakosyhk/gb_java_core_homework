package hw3;

import java.util.Arrays;


public class HomeWork3 {

    public static void main(String[] args) {
        runTask1();
        runTask2();
    }

    // Пуск задания 1...
    public static void runTask1() {

        // Тест 1...
        String[] arrStr = {"a", "b", "c", "d"};
        System.out.println("Проверка строк:" + Arrays.toString(arrStr));
        try {
            swapSequenceElements(arrStr, 0, 1);
        } catch (InvalidPositionException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Проверка строк:" + Arrays.toString(arrStr));
        }

        // Тест 2...
        Integer[] arrInt = {1, 2, 3, 4};
        System.out.println("Проверка чисел:" + Arrays.toString(arrInt));
        try {
            swapSequenceElements(arrInt, 0, 3);
        } catch (InvalidPositionException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Проверка строк:" + Arrays.toString(arrInt));
        }
    }

    /*
        Задание 1.

        Написать метод, который меняет два элемента массива местами
        (массив может быть любого ссылочного типа)
    */
    private static void swapSequenceElements(Object[] sequence, int idx1, int idx2) throws InvalidPositionException {

        // Валидация...
        if (idx1 == idx2 || idx1 < 0 || idx1 > sequence.length || idx2 < 0 || idx2 > sequence.length) {
            throw new InvalidPositionException("Некорректные позиции элементов для перестановки");
        }

        // Процедура перестановки...
        Object temp = sequence[idx1];
        sequence[idx1] = sequence[idx2];
        sequence[idx2] = temp;
    }

    /*
        Задание 2.

        Даны классы Fruit, Apple extends Fruit, Orange extends Fruit;
        Класс Box, в который можно складывать фрукты.
        Коробки условно сортируются по типу фрукта, поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
        Для хранения фруктов внутри коробки можно использовать ArrayList;

        Сделать метод getWeight(), который высчитывает вес коробки, зная
        вес одного фрукта и их количество: вес яблока – 1.0f, апельсина – 1.5f (единицы измерения не важны);

        Внутри класса Box сделать метод compare(), который позволяет сравнить текущую коробку с той, которую
        подадут в compare() в качестве параметра. true – если их массы равны, false в противоположном случае.
        Можно сравнивать коробки с яблоками и апельсинами;

        Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую.
        Помним про сортировку фруктов: нельзя яблоки высыпать в коробку с апельсинами.
        Соответственно, в текущей коробке фруктов не остается, а в другую перекидываются объекты, которые были в первой;

        Не забываем про метод добавления фрукта в коробку.
    */
    public static void runTask2() {

        // Создаём коробку яблок...
        Box<Apple> appleBox0 = new Box<>();

        // Создаём яблоки...
        Apple apple0 = new Apple(1f);
        Apple apple1 = new Apple(2f);
        Apple apple2 = new Apple(3f);

        // Наполняем коробку яблоками...
        appleBox0.setFruit(apple0);
        appleBox0.setFruit(apple1);
        appleBox0.setFruit(apple2);

        // Проверяем вес коробки яблок...
        System.out.println("Общий вес коробки с фруктами: " + appleBox0.getWeight());

        // Готовим коробоку для пересыпания яблок...
        Box<Apple> appleBox1 = new Box<>();

        System.out.println("Кол-во яблок в первой коробке: " + appleBox0.getSize());
        System.out.println("Кол-во яблок во второй коробке: " + appleBox1.getSize());

        // Пересыпаем яблоки...
        appleBox0.moveAt(appleBox1);

        System.out.println("Кол-во яблок в первой коробке: " + appleBox0.getSize());
        System.out.println("Кол-во яблок во второй коробке: " + appleBox1.getSize());

        // Создаём коробку сразу с апельсинами...
        Box<Orange> orangeBox0 = new Box<>(new Orange(4f), new Orange(2f));

        // Сравниваем коробки...
        System.out.println("Результат сравнения коробок(массы равны?): " + (orangeBox0.compare(appleBox1) ? "Да" : "Нет"));
    }
}
