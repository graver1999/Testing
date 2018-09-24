package com.main.java.bsu.epam_lab.lab1.objects;

import com.main.java.bsu.epam_lab.lab1.main.Marks;

import java.util.HashMap;
import java.util.Map;

public class Subject {
    private String name;
    private Map<Student, Integer> marksMap;

    public Subject(String name) {
        marksMap = new HashMap<>();
        this.name = name;
    }

    public Subject(String name, Map<Student, Integer> marksMap) {
        this.name = name;
        this.marksMap = marksMap;
    }

    public Double averageMark() {
        return Marks.averageMark( marksMap.values());
    }


    public void addStudentWithMark(Student student, Integer mark) {
        marksMap.put(student, mark);
    }

    @Override
    public String toString() {
        return "Subject name = " + name +  ", marks = " + marksMap ;
    }
}
