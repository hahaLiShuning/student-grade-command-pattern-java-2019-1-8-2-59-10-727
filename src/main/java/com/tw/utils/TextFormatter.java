package com.tw.utils;

import com.tw.model.Student;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class TextFormatter {
    private static final String STU_REGREX = "([^，]+)，([^，]+)，([^，]+)，数学：(\\d+(\\.\\d+)?)，语文：(\\d+(\\.\\d+)?)，英语：(\\d+(\\.\\d+)?)，编程：(\\d+(\\.\\d+)?)";
    private static final String reportText = "成绩单\n" +
            "姓名|数学|语文|英语|编程|平均分|总分 \n" +
            "========================\n" +
            "%1$s" +
            "========================\n" +
            "全班总分：%2$s\n" +
            "全班总平均分：%3$s";

    public  Student formatStudent(String input) {
        Student student = null;
        Matcher matcher = Pattern.compile(STU_REGREX).matcher(input);
        if (matcher.matches()) {
            student = new Student(matcher.group(1),
                    matcher.group(2),
                    matcher.group(3),
                    Double.parseDouble(matcher.group(4)),
                    Double.parseDouble(matcher.group(6)),
                    Double.parseDouble(matcher.group(8)),
                    Double.parseDouble(matcher.group(10)));
        }
        return student;
    }

    public String formatReport(List<Student> students) {
        String gradereportItem = "%1$s|%2$.1f|%3$.1f|%4$.1f|%5$.1f|%6$.1f|%7$.1f\n";
        String itemText = students.stream()
                .map(item -> String.format(gradereportItem, item.getName(),
                        item.getMathsScore(),
                        item.getChineseScore(),
                        item.getEnglishScore(),
                        item.getProgramScore(),
                        item.getAverageScore(),
                        item.getTotalScore())).collect(Collectors.joining());
        Double totalScore = students.stream().mapToDouble(x -> x.getTotalScore()).sum();
        return String.format(reportText, itemText, totalScore, totalScore / students.size());
    }

}
