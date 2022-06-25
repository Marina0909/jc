package Lesson9;

import java.util.*;
import java.util.stream.Collectors;

public class Main9 {
    public static void main(String[] args) {
        ArrayList <Student> students;
        students = new ArrayList<>(Arrays.asList(
                new StudentUni("Степан", new ArrayList<>(Arrays.asList(StudentUni.CourseUni.ENGLISH,
                        StudentUni.CourseUni.ALGEBRA, StudentUni.CourseUni.ANALIZ))),
                new StudentUni("Семен", new ArrayList<>(Arrays.asList(StudentUni.CourseUni.ENGLISH,
                        StudentUni.CourseUni.BIOLOGY))),
                new StudentUni("Анна", new ArrayList<>(Arrays.asList(StudentUni.CourseUni.ANALIZ))),
                new StudentUni("Кондратий", new ArrayList<>(Arrays.asList(StudentUni.CourseUni.ENGLISH,
                        StudentUni.CourseUni.BIOLOGY))),
                new StudentUni("Алексей", new ArrayList<>(Arrays.asList(StudentUni.CourseUni.ENGLISH,
                        StudentUni.CourseUni.HISTORY, StudentUni.CourseUni.BIOLOGY)))));



        System.out.println(fullCourseUniList(students));
        System.out.println(curiousStudentsList(students));


    }
    public static Set<Course> fullCourseUniList(ArrayList<Student> students) {

        return students.stream()
                .map(o -> o.getAllCourses())
                .flatMap(s -> s.stream())
                .collect(Collectors.toSet());
    }
    public static List<Student> curiousStudentsList(ArrayList<Student> students){
        return students.stream()
                .sorted((c1, c2) -> c2.getAllCourses().size()-c1.getAllCourses().size())
                .limit(3)
                .collect(Collectors.toList());
    }

}
