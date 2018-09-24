package com.main.java.bsu.epam_lab.lab1.objects;

import com.main.java.bsu.epam_lab.lab1.main.Marks;

import java.util.ArrayList;
import java.util.List;

public class Group {
    private String name;
    private List<Student> students;
    private List<Integer> marks;

    public Group(String name) {
        this.name = name;
        students = new ArrayList<>();
        marks = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }


    public List<Student> getStudents() {
        return students;
    }

    @Override
    public String toString() {
        return "Group " + name +  ", students = " + students;
    }

    public double averageMark() {
        return Marks.averageMark(getMarks());
    }

    public List<Integer> getMarks() {
        this.marks = new ArrayList<>();
        for (Student student : students) {
            marks.addAll(student.getMarks());
        }
        return marks;
    }
}