package hw5;

import java.util.Arrays;

/*

1. Реализовать сохранение данных в csv файл;
2. Реализовать загрузку данных из csv файла. Файл читается целиком.
Структура csv файла:
| Строка заголовок с набором столбцов |
| Набор строк с целочисленными значениями |
| * Разделитель между столбцами - символ точка с запятой (;) |

Пример:
Value 1;Value 2;Value 3
100;200;123
300,400,500
Для хранения данных использовать класс вида:
public class AppData {
  private String[] header;
  private int[][] data;

 // ...
}
Если выполняется save(AppData data), то старые данные в файле полностью перезаписываются.
*/
public class Main {
    public static void main(String[] args) {
        AppData appData = new AppData();

        // Загружаем файл в память...
        appData.load("example.csv");

        // Печатаем заголовок...
        System.out.println(Arrays.toString(appData.getHeader()));

        // Печатаем данные...
        System.out.println(Arrays.deepToString(appData.getData()));

        // Сохраняем файл...
        appData.save("result.csv");
    }
}
