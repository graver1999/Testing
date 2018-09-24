package com.main.java.bsu.epam_lab.lab1.objects;

import com.main.java.bsu.epam_lab.lab1.main.Marks;

import java.util.ArrayList;
import java.util.List;

public class University {
    private static University university;
    private List<Faculty> faculties;
    private List<Subject> subjects;
    private List<Integer> marks;

    public static University getInstance() {
        if (university == null)
            university = new University();
        return university;
    }

    private University() {
        faculties = new ArrayList<>();
        subjects = new ArrayList<>();
        marks = new ArrayList<>();

        initDefaultFaculties();
    }

    private void initDefaultFaculties() {
        faculties.add(new Faculty("MMF"));
        faculties.add(new Faculty("FAMCS"));
        faculties.add(new Faculty("SBMT"));
        faculties.add(new Faculty("RFE"));
        faculties.add(new Faculty("JOURN"));

    }

    public List<Faculty> getFaculties() {
        return faculties;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public Double averageMark() {
        for (Faculty faculty : faculties) {
            marks.addAll(faculty.getMarks());
        }
        return Marks.averageMark(marks);
    }

    public void addSubject(Subject subject) {
        subjects.add(subject);
    }
}