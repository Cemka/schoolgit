package ru.school.homework.april.sixteenth;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;

public class SortSumWrite {

    public static void main(String[] args) throws RuntimeException {
        ArrayList<String> list = new ArrayList<>();
        try {
            Files.lines(Paths.get(EnumMaxMinFromFile.PATH), StandardCharsets.UTF_8).sorted(Comparator.comparingInt(s -> {
                int sum = 0;
                int el = Integer.parseInt(s);
                while (el > 0) {
                    sum += el % 10;
                    el /= 10;
                }
                return sum;
                    }
            )).forEach(list::add);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }



        try {
            Path filePath = Paths.get(EnumMaxMinFromFile.PATH_OUT);
            BufferedWriter writer = Files.newBufferedWriter(filePath);

            for (String line : list) {
                writer.write(line);
                writer.newLine();
            }

            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
