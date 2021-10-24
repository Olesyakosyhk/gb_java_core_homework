package hw9;

import java.util.ArrayList;
import java.util.List;


public class Student {
    private final String name;
    private final List<Course> courses = new ArrayList<>();

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setCourse(Course course) {
        courses.add(course);
    }

    public List<Course> getAllCourses() {
        return courses;
    }
}
