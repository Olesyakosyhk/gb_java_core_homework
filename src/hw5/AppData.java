package hw5;

import java.io.*;
import java.util.ArrayList;


public class AppData {
    private String[] header;
    private Integer[][] data;

    // Получение заголовка...
    public String[] getHeader() {
        return header;
    }

    // Добавление заголовка...
    public void setHeader(String[] header) {
        this.header = header;
    }

    // Получить данные...
    public Integer[][] getData() {
        return data;
    }

    // Занести данные...
    public void setData(Integer[][] data) {
        this.data = data;
    }

    // Сохранить файл...
    public void save(String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(rowToString(header));
            for (Integer[] row : data) {
                writer.write(rowToString(row));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Преобразование данных в строковое представление...
    private <T> String rowToString(T[] row) {
        StringBuilder result = new StringBuilder();

        for (int i=0; i<row.length; i++) {
            result.append(row[i].toString());
            if (i !=row.length - 1) {
                result.append(";");
            }
        }

        result.append("\n");
        return result.toString();
    }

    // Загрузить файл...
    public void load(String fileName) {
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {

            // Считаваем заголовок...
            header = bufferedReader.readLine().split(";");

            // Данные...
            ArrayList<Integer[]> dataList = new ArrayList<>();

            String tempString;
            while ((tempString = bufferedReader.readLine()) != null) {
                dataList.add(stringToDataRow(tempString));
            }

            data = dataList.toArray(new Integer[][]{{}});

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    // Преобразование строки данных в массив...
    private Integer[] stringToDataRow(String str) {
        String[] strings = str.split(";");

        Integer[] integers = new Integer[strings.length];
        for (int i = 0; i < strings.length; i++) {
            integers[i] = Integer.parseInt(strings[i]);
        }

        return integers;
    }
}
