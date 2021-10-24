package hw1;

import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;


public class Team {
    private String title;   // Название команды...
    private String[] participants;  // Участники...
    private Map<Course, String[]> mapCourseCompleted = new HashMap<>();     // Полосы, которые преодолели участники...

    public Team(String title, String[] participants) {
        this.title = title;
        this.participants = participants;
    }

    // Получить информацию о команде...
    public void getInfo() {
        System.out.println(this.title + ":");
        for(int i=0; i<this.participants.length; i++) {
            System.out.println(this.participants[i]);
        }
    }

    // Информация о всех пройденных полосах препятствий команды...
    public void showResult() {
        this.mapCourseCompleted.entrySet().forEach(entry -> {
            System.out.println(entry.getKey() + " : " + Arrays.toString(entry.getValue()));
        });
    }

    // Добавляем полосу пройденную командой...
    public void setCourse(Course course) {
        this.mapCourseCompleted.put(course, this.participants);
    }

    // Кол-во участников команды...
    public int getCountParticipant() {
        return this.participants.length;
    }

    // Имя участника, по индексу...
    public String getParticipantNameByIdx(int idx) {
        return this.participants[idx];
    }
}