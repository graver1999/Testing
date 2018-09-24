package com.main.java.bsu.epam_lab.lab1.objects;

import com.main.java.bsu.epam_lab.lab1.main.Marks;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Student {
    private String name;
    private Map<Subject, Integer> marksMap;

    public Student(String name) {
        marksMap = new HashMap<>();
        this.name = name;
    }

    public Student(String name, Map<Subject, Integer> marks) {
        this.name = name;
        this.marksMap = marks;
    }

    public Double averageMark() {
        return Marks.averageMark( marksMap.values());
    }

    private void printMarks() {
        for (Map.Entry<Subject, Integer> subjectIntegerEntry : marksMap.entrySet()) {
            System.out.println(subjectIntegerEntry.getKey() +" " + subjectIntegerEntry.getValue());
        }
    }

    public void addSubject(Subject subject, Integer mark) {
        marksMap.put(subject,mark);
        subject.addStudentWithMark(this,mark);
    }

    @Override
    public String toString() {
        return "Student " + name +  ", marks = " + marksMap.values();
    }

    public Collection<Integer> getMarks() {
        return marksMap.values();
    }
}