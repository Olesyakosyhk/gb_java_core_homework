package hw8;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class UserInterface {

    private final Controller controller = new Controller();

    public void runApplication() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("""
                Добро пожаловать!
                Вы можете завершить работу приложения на любом этапе ввода.
                Для этого введите любое из слов: q / exit / выход
                """);

        while (true) {
            System.out.println("Введите название города на английском языке");
            String city = scanner.nextLine();   // Пользовательский ввод...

            // Проверка и обработка сценария завершения работы...
            checkIsExit(city);

            // Заносим название города в state...
            setGlobalCity(city);

            // Принимаем решение по сценарию...
            System.out.println(
                    "Введите ответ:\n" +
                    "1 - Получить текущую погоду\n" +
                    "2 - Получить погоду на следующие 5 дней\n" +
                    "3 - Получить погоду из DB"
            );

            // Ожидание пользовательского ввода...
            String result = scanner.nextLine();

            // Проверка и обработка сценария завершения работы...
            checkIsExit(result);

            // Валидация пользовательского ввода...
            try {
                validateUserInput(result);
            } catch (IOException e) {
                e.printStackTrace();
                continue;
            }

            try {
                notifyController(result);
            } catch (IOException | SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Обработка выхода...
    private void checkIsExit(String result) {
        if (result.toLowerCase().equals("выход")
                || result.toLowerCase().equals("exit")
                || result.toLowerCase().equals("q")) {
            System.out.println("Завершаю работу");
            System.exit(0);
        }
    }

    // Заносим название города в state...
    private void setGlobalCity(String city) {
        ApplicationGlobalState.getInstance().setSelectedCity(city);
    }

    // Валидация пользовательского ввода: при выборе сценария...
    private void validateUserInput(String userInput) throws IOException {
        if (userInput == null || userInput.length() != 1) {
            throw new IOException("Incorrect user input: expected one digit as answer, but actually get " + userInput);
        }
        int answer = 0;
        try {
            answer = Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new IOException("Incorrect user input: character is not numeric!");
        }
    }

    private void notifyController(String input) throws IOException, SQLException {
        controller.onUserInput(input);
    }
}