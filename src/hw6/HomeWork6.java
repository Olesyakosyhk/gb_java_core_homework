/*
Задание 6.

1. С помощью http запроса получить в виде json строки погоду в Санкт-Петербурге на период времени,
пересекающийся со следующим занятием (например, выборка погода на следующие 5 дней - подойдет)

2. Подобрать источник самостоятельно.
Можно использовать api accuweather, порядок следующий:
- зарегистрироваться,
- зарегистрировать тестовое приложение для получения api ключа,
- найдите нужный endpoint и изучите документацию.

Бесплатный тарифный план предполагает получение погоды не более чем на 5 дней вперед
(этого достаточно для выполнения д/з).
*/

package hw6;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import static java.nio.charset.StandardCharsets.UTF_8;


public class HomeWork6 {

    // Домен...
    static String BASE_URL = "http://dataservice.accuweather.com";

    // Токен...
    static String API_KEY = "kV9avv9i9oDnAjwgPuc8AhkHz2vzC7hK";

    // ID города в системе: Санкт-Петербург...
    static Integer TARGET_CITY_ID = 295212;

    // Получить ссылку на погоду за 1 день...
    static String get1daysURL(Integer cityID) {
        return BASE_URL + "/forecasts/v1/daily/1day/" + cityID + "?apikey=" + API_KEY;
    }

    // Получить ссылку на погоду за 5 суток...
    static String get5daysURL(Integer cityID) {
        return BASE_URL + "/forecasts/v1/daily/5day/" + cityID + "?apikey=" + API_KEY;
    }

    // Печать выходного потока в консоль...
    static void printResponseData(InputStream in) {
        new BufferedReader(new InputStreamReader(in, UTF_8))
                .lines()
                .forEach(System.out::println);
    }

    public static void main(String[] args) throws IOException {

        // Тест 1: Погода за 1 день...

        // Формируем целевой URL...
        URL target_url = new URL(get1daysURL(TARGET_CITY_ID));

        // Напечатать тело запроса...
        printResponseData(target_url.openStream());

        // Тест 2: Погода за 5 дней...

        // Формируем целевой URL...
        target_url = new URL(get5daysURL(TARGET_CITY_ID));

        // Напечатать тело запроса...
        printResponseData(target_url.openStream());
    }
}
