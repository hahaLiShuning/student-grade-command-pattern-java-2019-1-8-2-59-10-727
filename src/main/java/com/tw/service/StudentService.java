package com.tw.service;

import com.tw.model.Student;
import com.tw.utils.FileUtils;
import com.tw.utils.TextFormatter;

import java.util.List;
import java.util.stream.Collectors;

public class StudentService {
    private TextFormatter formatter;

    public StudentService() {
        this.formatter = new TextFormatter();
    }

    public boolean addStudent(Student student) {
        if (!isExist(student)) {
            FileUtils.writeRecord(student.toString());
        } else {
            return false;
        }
        return true;
    }

    public boolean isExist(Student student) {
        List<String> records = FileUtils.readRecord();
        return records.stream()
                .map(formatter::formatStudent)
                .map(x -> x.getNumber())
                .filter(x -> x == student.getNumber())
                .count() > 0;
    }

    public List<Student> findByNums(List<String> num) {
        System.out.println(num.get(0));
        List<String> records = FileUtils.readRecord();
        return records.stream()
                .map(formatter::formatStudent)
                .filter(x -> num.contains(x.getNumber()))
                .collect(Collectors.toList());
    }
}
