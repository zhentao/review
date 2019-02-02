package com.zhentao.review.google;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * 给你一堆学生成绩的数字成绩（比如99,98,97,96,95,94,93,92,91,90），按照排名转换为A,B,C,D,E的letter
 * grade。前20%得A，20%~40%得B，依次类推。要求必须用贪心法做。 这个例子中就是99, 98的人拿A，97, 96的人拿B.
 * 如果有相同成绩，就确保排名一致。比如100,100,99,98,97的排名就是1,1,3,4,5
 * 
 * @author zhentao
 *
 */
public class LetterGradeGreedy {
    public static void main(final String[] args) {
        int[] input = { 100, 100, 100, 98, 97, 96 };
        System.out.println(grade(input));
        
        input = new int[] { 100, 99, 98, 97, 96 };
        System.out.println(grade(input));
        input = new int[] { 100, 99,99,99,99,99,99 };
        System.out.println(grade(input));
        
        input = new int[] { 100, 99, 98, 98, 96, 95, 94 };
        System.out.println(grade(input));
        input = new int[] { 100, 99, 98, 97, 97, 95, 94, 93 };
        System.out.println(grade(input));
    }

    public static Map<Character, List<Integer>> grade(final int[] input) {
        final char[] letterGrade = { 'A', 'B', 'C', 'D', 'E' };
        final Map<Integer, List<Integer>> buckets = new TreeMap<>((a, b) -> b - a);
        for (final int grade : input) {
            buckets.computeIfAbsent(grade, k -> new ArrayList<>()).add(grade);
        }
        //average # of students allowed in each grade
        //you should discuss with the interviewer on how to calculate it
        //for example, if you have 6 students, which letter grade is the extra student supposed to have? 
        //the following way adds all remainders to letter E;
        final int studentsPerLetterGrade = input.length / letterGrade.length;
        
        final Map<Character, List<Integer>> finalGrade = new TreeMap<>();
        int currentAllowed = studentsPerLetterGrade;
        int added = 0;//track how many students processed
        int i = 0;
        char nextLetterGrade = letterGrade[i];
        for (final Integer grade : buckets.keySet()) {
            final List<Integer> studentGrade = finalGrade.computeIfAbsent(nextLetterGrade, k -> new ArrayList<>());
            //Here is the greedy algo: add as many students as possible to grade A
            //It could be over 20% if there is a tie
            if (studentGrade.size() < currentAllowed) {
                final List<Integer> gradeInOneBucket = buckets.get(grade);
                studentGrade.addAll(gradeInOneBucket);
                gradeInOneBucket.clear();
            } else {
                added += studentGrade.size();
                i++;
                //skip some letter grades if needed
                while ((currentAllowed = (i+1) * studentsPerLetterGrade - added) <= 0) {
                    i++;
                }
                if (i >= letterGrade.length) {//add remainders to the last letter grade
                    nextLetterGrade = letterGrade[letterGrade.length-1];
                } else {
                    nextLetterGrade = letterGrade[i];
                }
                finalGrade.computeIfAbsent(nextLetterGrade, k -> new ArrayList<>()).addAll(buckets.get(grade));
            }
        }
        return finalGrade;
    }
}
