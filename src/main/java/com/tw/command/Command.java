package com.tw.command;

import java.util.Scanner;

public class Command {

    public static Scanner cliReader = new Scanner(System.in);

    private static final String MAIN_CONTENT = "***********\n" +
            "1. 添加学生\n" +
            "2. 生成成绩单\n" +
            "3. 退出\n" +
            "请输入你的选择（1～3):\n" +
            "***********\n";

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
        return true;
    }
}
