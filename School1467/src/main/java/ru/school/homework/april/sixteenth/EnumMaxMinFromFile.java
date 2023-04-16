package ru.school.homework.april.sixteenth;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class EnumMaxMinFromFile {

    public static final String PATH = "input.txt";
    public static final String PATH_OUT = "output.txt";

    public static void main(String[] args) {
        ArrayList<Integer> list;
        File file = new File(PATH);
        int min;
        int max;
        list = getIntegerFile(file);
        if(list.stream().noneMatch(s -> s % 2 == 0 && s > 0)){
            System.out.println("Is not enum");
        } else {
            max = list.stream().filter(s -> s % 2 == 0 && s > 0).max(Comparator.naturalOrder()).get();
            min = list.stream().filter(s -> s % 2 == 0 && s > 0).min(Comparator.naturalOrder()).get();
            System.out.println("Max:" + max + " " + "Min: " + min);
        }


    }

    static ArrayList<Integer> getIntegerFile(File file) {

        ArrayList<Integer> list = new ArrayList<>();
        try {
            Scanner out = new Scanner(file);
            while(out.hasNext()){
                list.add(Integer.valueOf(out.next()));
            }
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;
    }
}
