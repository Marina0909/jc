package Lesson9;

import java.util.ArrayList;
import java.util.List;

public class StudentUni implements Student {

    public enum CourseUni implements Course {
        ALGEBRA, HISTORY, ANALIZ, ENGLISH, BIOLOGY;
    }
    String name;

    List<CourseUni> courseUniList;

    public StudentUni(String name, List<CourseUni> courseUniList) {
        this.name = name;
        this.courseUniList = courseUniList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Course> getAllCourses() {
        ArrayList<Course> list = new ArrayList<>();
        for(CourseUni courseUni : this.courseUniList) {
            final boolean add = list.add(courseUni);
        }
        return list;
    }

    public void setCourseUniList(List<CourseUni> courseUniList) {
        this.courseUniList = courseUniList;
    }

    @Override
    public String toString() {
        return "StudentUni{" +
                "name='" + name + '\'' +
                ", courseUniList=" + courseUniList +
                '}';
    }
}
