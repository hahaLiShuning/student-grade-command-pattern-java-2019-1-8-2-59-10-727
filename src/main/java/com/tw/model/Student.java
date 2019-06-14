package com.tw.model;

public class Student {
    private String name;
    private String number;
    private double mathsScore;
    private double chineseScore;
    private double englishScore;
    private double programScore;

    public Student(String name, String number, double mathsScore, double chineseScore, double englishScore, double programScore) {
        this.name = name;
        this.number = number;
        this.mathsScore = mathsScore;
        this.chineseScore = chineseScore;
        this.englishScore = englishScore;
        this.programScore = programScore;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public double getMathsScore() {
        return mathsScore;
    }

    public double getChineseScore() {
        return chineseScore;
    }

    public double getEnglishScore() {
        return englishScore;
    }

    public double getProgramScore() {
        return programScore;
    }

    public double getTotalScore() {
        return chineseScore + mathsScore + englishScore + programScore;
    }

    public double getAverageScore() {
        return getTotalScore() / 4;
    }

    @Override
    public String toString() {
        return String.format("%1$s，%2$s，数学：%3$.1f，语文：%4$.1f，英语：%5$.1f，编程：%6$.1f",
                name, number, mathsScore, chineseScore, englishScore, programScore);
    }
}