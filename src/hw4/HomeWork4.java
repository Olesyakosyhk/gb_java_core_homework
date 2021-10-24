package hw4;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;


public class HomeWork4 {

    public static void main(String[] args) {
        System.out.println("Запуск задания 1");
        run_task1();

        System.out.println("\nЗапуск задания 2");
        run_task2();
    }

    /*
        Задание 1.

        Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся).
        Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
        Посчитать, сколько раз встречается каждое слово.
    */
    public static void run_task1() {
        String[] catBreeds = {
                "Регдолл",

                // 2...
                "Мейн-кун",
                "Мейн-кун",

                // 3...
                "Саванна",
                "Саванна",
                "Саванна",

                // 4...
                "Шартрез",
                "Шартрез",
                "Шартрез",
                "Шартрез",
        };
        System.out.println("Исходные значения: " + Arrays.toString(catBreeds));

        // Печатаем уникальные слова...
        Set<String> uniqueCatBreeds = new HashSet<>(Arrays.asList(catBreeds));
        System.out.println("Уникальные значения: " + uniqueCatBreeds + '\n');

        // Подсчёт повторений. Версия 1...
        System.out.println("[Version 1] Подсчёт повторений.\nОбщее количество: " + catBreeds.length);

        HashMap<String, Integer> statistic = new HashMap<>();
        for(String value : uniqueCatBreeds) {
            for (String catBreed : catBreeds) {
                if (value.equals(catBreed)) {
                    var countVal = statistic.get(value);

                    // Инициируем счётчик...
                    if (countVal == null) {
                        statistic.put(value, 1);

                    // Увеличивем счётчик...
                    } else {
                        statistic.put(value, ++countVal);
                    }
                }
            }
        }
        System.out.println(statistic);

        // Подсчёт повторений. Версия 2...
        System.out.println("[Version 2] Подсчёт повторений.\nОбщее количество: " + catBreeds.length);
        List<String> catBreedsList = Arrays.asList(catBreeds);
        Map<String, Long> statistic2 = catBreedsList.stream().collect(
                Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                )
        );
        System.out.println(statistic2);
    }

    /*
        Задание 2.

        Написать простой класс «Телефонный Справочник», который хранит в себе список фамилий и телефонных номеров.
        В этот телефонный справочник с помощью метода add() можно добавлять записи, а с помощью
        метода get() искать номер телефона по фамилии.
        Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев),
        тогда при запросе такой фамилии должны выводиться все телефоны.

        Доп. требования:
        Желательно не добавлять лишний функционал
        (дополнительные поля (имя, отчество, адрес), взаимодействие с пользователем через консоль и т.д).
        Консоль использовать только для вывода результатов проверки телефонного справочника.
    */
    public static void run_task2() {
        PhoneBook phoneBook = new PhoneBook();

        // Заполняем телефонную книгу...
        phoneBook.add("Фамилия 0", "+79997770000");
        phoneBook.add("Фамилия 0", "+79997770001");
        phoneBook.add("Фамилия 0", "+79997770002");

        phoneBook.add("Фамилия 1", "+79997770010");
        phoneBook.add("Фамилия 1", "+79997770011");

        phoneBook.add("Фамилия 2", "+79997770020");

        // Получение данных...
        var phones0 = phoneBook.get("Фамилия 0");
        System.out.println("Фамилия 0: " + phones0);

        var phones1 = phoneBook.get("Фамилия 1");
        System.out.println("Фамилия 1: " + phones1);

        var phones2 = phoneBook.get("Фамилия 2");
        System.out.println("Фамилия 2: " + phones2);

        var phones999 = phoneBook.get("Фамилия 999");
        System.out.println("Фамилия 999: " + phones999);
    }

}
