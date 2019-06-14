package com.tw.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {
    public static List<String> readRecord() {

        ArrayList<String> records = new ArrayList<>();
        try {
            FileReader reader = new FileReader("src/main/resources/students.txt");
            BufferedReader br = new BufferedReader(reader);
            String str;
            while ((str = br.readLine()) != null) {
                records.add(str);
            }
            br.close();
            reader.close();
        } catch (IOException e) {
            return records;
        }
        return records;
    }
    public static boolean writeRecord(String record) {
        try {
            FileWriter writer = new FileWriter("src/main/resources/students.txt", true);
            BufferedWriter bw = new BufferedWriter(writer);
            bw.write(record);
            bw.newLine();
            bw.flush();
            bw.close();
            writer.close();
        } catch (IOException e) {
            return false;
        }
        return true;
    }
}
