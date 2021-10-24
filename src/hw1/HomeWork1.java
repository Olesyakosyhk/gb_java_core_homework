package hw1;

public class HomeWork1 {

    public static void main(String[] args) {

        // Создаём массив участников...
        String[] participants = {"Участник 1", "Участник 2", "Участник 3", "Участник 4"};

        // Создаём команду с участниками...
        Team teamA = new Team("Команда А", participants);
        teamA.getInfo();

        // I.
        // Создаём препятствия...
        String[] courseNames = {"Забор", "Стена", "Ступени"};

        // Создаём полосу...
        Course c0 = new Course(courseNames);

        // Просим пройти полосу...
        c0.doIt(teamA);

        // Результаты прохождения полос командой...
        teamA.showResult();
    }
}
