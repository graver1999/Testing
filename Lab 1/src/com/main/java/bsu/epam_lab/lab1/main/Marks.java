package com.main.java.bsu.epam_lab.lab1.main;

import java.util.Collection;

public class Marks {
    public static Double averageMark(Collection<Integer> marks) {
        return 1.0*marksSum(marks)/marks.size();
    }
    private static Integer marksSum(Collection<Integer> marks) {
        Integer sum = 0;
        for (Integer mark : marks) {
            sum += mark;
        }
        return sum;
    }
}