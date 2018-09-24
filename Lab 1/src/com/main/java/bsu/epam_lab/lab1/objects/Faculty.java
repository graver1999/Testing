package com.main.java.bsu.epam_lab.lab1.objects;

import com.main.java.bsu.epam_lab.lab1.main.Marks;

import java.util.ArrayList;
import java.util.List;

public class Faculty {
    private String name;
    private List<Group> groups;
    private List<Integer> marks;


    public Faculty(String name) {
        this.name = name;

        groups = new ArrayList<>();
        marks = new ArrayList<>();
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void addGroup(Group group) {
        groups.add(group);
    }

    @Override
    public String toString() {
        return "Faculty name = " + name  + ", group = " + groups + '}';
    }
    public Double avgMark() {
        return Marks.averageMark(getMarks());
    }
    public List<Integer> getMarks() {
        this.marks = new ArrayList<>();
        for (Group group : groups) {
            marks.addAll( group.getMarks() );
        }
        return marks;
    }
}