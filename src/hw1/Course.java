package hw1;

public class Course {
    private String[] courses;

    public Course(String[] courseNames) {
        this.courses = courseNames;
    }

    public void doIt(Team team) {

        // Фиксирование прохождения полосы текущей полосы препятствий...
        team.setCourse(this);

        // Информирование о прогрессе..
        for(int participantIdx=0; participantIdx<team.getCountParticipant(); participantIdx++) {
            for (int courseIdx = 0; courseIdx < courses.length; courseIdx++) {
                System.out.println(team.getParticipantNameByIdx(participantIdx) + " : " + "Прошёл препятствие " + this.courses[courseIdx]);
            }
        }
    }
}
