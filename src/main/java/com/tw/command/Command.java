package com.tw.command;

import com.tw.model.Student;
import com.tw.service.StudentService;
import com.tw.utils.TextFormatter;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Command {

    public static Scanner cliReader = new Scanner(System.in);

    private static StudentService studentService;
    private static TextFormatter formatter;

    private static final String MAIN_CONTENT = "***********\n" +
            "1. 添加学生\n" +
            "2. 生成成绩单\n" +
            "3. 退出\n" +
            "请输入你的选择（1～3):\n" +
            "***********\n";

    private static final String ADD_STU_CONTENT = "请输入学生信息（格式：姓名, 学号，数学：分数，语文：分数，英语：分数，编程：分数），按回车提交：\n";
    private static final String ADD_ERROR_CONTENT = "请按正确的格式输入（格式：姓名, 学号, 学科: 成绩, ...）\n";
    private static final String GEN_GRADE_REPORT_CONTENT = "请输入要打印的学生的学号（格式： 学号, 学号,...），按回车提交：\n";
    private static final String REPORT_ERROR_CONTENT = "请按正确的格式输入要打印的学生的学号（格式： 学号, 学号,...），按回车提交：\n";

    public Command() {
        this.studentService = new StudentService();
        this.formatter = new TextFormatter();
    }

    public void init() {
        while (true) {
            System.out.print(MAIN_CONTENT);
            String line = cliReader.nextLine();
            boolean shouldExit = processChoice(line);
            if (shouldExit) {
                System.out.print("已经退出!\n\n");
                break;
            }
        }
    }

    public boolean processChoice(String choice) {
        boolean shouldExit = false;
        switch (choice) {
            case "1":
                processAddStu(ADD_STU_CONTENT);
                break;
            case "2":
                processGennerateReport(GEN_GRADE_REPORT_CONTENT);
                break;
            case "3":
                shouldExit = true;
                break;
            default:
                init();
        }
        return shouldExit;
    }

    public void processAddStu(String msg) {
        System.out.print(msg);
        String input = cliReader.nextLine();
        Student student = formatter.formatStudent(input);
        if (student != null) {
            studentService.addStudent(student);
        } else {
            processAddStu(ADD_ERROR_CONTENT);
        }
    }

    public void processGennerateReport(String msg) {
        System.out.print(msg);
        String input = cliReader.nextLine();
        String[] nums = input.split(", ");
        List<Student> students = this.studentService.findByNums(Arrays.asList(nums));
        if (students.size() > 0) {
            String report = formatter.formatReport(students);
            System.out.println(report);
        } else {
            processGennerateReport(REPORT_ERROR_CONTENT);
        }
    }
}
