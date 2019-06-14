package com.tw.model;

public class Student {
    private String name;
    private String number;
    private String nationality;
    private double mathsScore;
    private double chineseScore;
    private double englishScore;
    private double programScore;

    public Student(String name, String nationality, String number, double mathsScore, double chineseScore, double englishScore, double programScore) {
        this.name = name;
        this.number = number;
        this.nationality = nationality;
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
        double totalScore = chineseScore + mathsScore + englishScore + programScore;
        totalScore = totalScore + (this.nationality.equals("汉") ? 0 : 10);
        return totalScore;
    }

    public double getAverageScore() {
        return getTotalScore() / 4;
    }

    public String getNationality() {
        return nationality;
    }

    @Override
    public String toString() {
        return String.format("%1$s，%2$s，%3$s，数学：%4$.1f，语文：%5$.1f，英语：%6$.1f，编程：%7$.1f",
                name, number, nationality, mathsScore, chineseScore, englishScore, programScore);
    }
}