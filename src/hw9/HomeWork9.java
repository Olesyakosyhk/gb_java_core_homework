/*
    Задание 9.

    Имеется следующая структура:

    interface Student {
        String getName();
        List<Course> getAllCourses();
    }
    interface Course {}

    1. Написать функцию, принимающую список Student и возвращающую список уникальных курсов,
        на которые подписаны студенты.
    2. Написать функцию, принимающую на вход список Student и возвращающую список из трех самых любознательных
        (любознательность определяется количеством курсов).
    3. Написать функцию, принимающую на вход список Student и экземпляр Course,
        возвращающую список студентов, которые посещают этот курс.

*/

package hw9;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class HomeWork9 {

    public static void main(String[] args) {

        // Подготовка...
        List<Course> courses = prepareCourse();
        List<Student> students = prepareStudent(courses);

        List<String> uniqueCourses = getUniqueCourseNames(students);
        System.out.println("Список уникальных курсов: " + uniqueCourses.toString());

        List<Student> top3Students = getTop3Inquisitive(students);
        System.out.println("\nТОП-3 любознательных студентов:");
        top3Students.stream()
                .map(Student::getName)
                .forEach(System.out::println);

        List<Student> studentsOnCourse = getStudentsOnCourse(students, courses.get(2));
        System.out.println("\nСписок студентов на целевом курсе:");
        studentsOnCourse.stream()
                .map(Student::getName)
                .forEach(System.out::println);
    }

    // Подготовка курсов...
    static List<Course> prepareCourse() {
        List<Course> courses = new ArrayList<>();
        for(int i=0; i<=5; i++) {
            courses.add(new Course("Курс " + i));
        }

        return courses;
    }

    // Подготовка студентов...
    static List<Student> prepareStudent(List<Course> courses) {
        List<Student> students = new ArrayList<>();

        // Подготовка первого студента...
        Student _student = new Student("Name 0");
        _student.setCourse(courses.get(0));
        _student.setCourse(courses.get(1));
        _student.setCourse(courses.get(2));
        _student.setCourse(courses.get(3));
        _student.setCourse(courses.get(4));

        students.add(_student);

        // Подготовка второго студента...
        _student = new Student("Name 1");
        _student.setCourse(courses.get(0));
        _student.setCourse(courses.get(1));
        _student.setCourse(courses.get(2));
        _student.setCourse(courses.get(3));

        students.add(_student);

        // Подготовка третьего студента...
        _student = new Student("Name 2");
        _student.setCourse(courses.get(0));
        _student.setCourse(courses.get(1));
        _student.setCourse(courses.get(2));

        students.add(_student);

        // Подготовка четвертого студента...
        _student = new Student("Name 3");
        _student.setCourse(courses.get(0));
        _student.setCourse(courses.get(1));

        students.add(_student);

        return students;
    }

    // Получить список уникальных курсов...
    static List<String> getUniqueCourseNames(List<Student> students) {
        return students.stream()
                .map(Student::getAllCourses)
                .flatMap(Collection::stream)
                .map(Course::getName)
                .distinct()
                .collect(Collectors.toList());
    }

    // Получить ТОП-3 любознательных...
    static List<Student> getTop3Inquisitive(List<Student> students) {
        return students.stream()
                .sorted((stud1, stud2) -> stud2.getAllCourses().size() - stud1.getAllCourses().size())
                .limit(3)
                .collect(Collectors.toList());
    }

    // Получить список студентов на целевом курсе...
    static List<Student> getStudentsOnCourse(List<Student> students, Course course) {
        String courseName = course.getName();
        return students.stream()
                .filter(stud -> stud.getAllCourses().stream().anyMatch(c -> c.getName().equals(courseName)))
                .collect(Collectors.toList());
    }
}
