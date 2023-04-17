package ru.school.exams.seventeenth;

import java.io.*;
import java.util.*;

public class GetResExam {
    public static void main(String[] args){
        Map<String, Integer> scores = new HashMap<>();
        try (Scanner scanner = new Scanner(new File("results.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(" ");
                String name = parts[0] + " " + parts[1];
                int score = Integer.parseInt(parts[2]) + Integer.parseInt(parts[3]) + Integer.parseInt(parts[4]);
                scores.put(name, score);
            }
            List<String> students = scores.entrySet().stream()
                    .filter(entry -> entry.getValue() > 240)
                    .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                    .map(entry -> entry.getKey() + " " + entry.getValue())
                    .toList();
            try (PrintWriter writer = new PrintWriter("resultsSort.txt")) {
                students.forEach(writer::println);
            } catch (FileNotFoundException e) {
                System.out.println("Fail write!");
            }
        } catch (FileNotFoundException e) {
            System.out.println("Fail read!");
        }
    }
}
