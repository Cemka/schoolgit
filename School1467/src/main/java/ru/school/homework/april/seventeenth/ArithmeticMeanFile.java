package ru.school.homework.april.seventeenth;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.OptionalDouble;
import java.util.Scanner;
import java.util.stream.Stream;

public class ArithmeticMeanFile {

    public static final String PATH = "input.txt";
    public static final String PATH_OUT = "output.txt";

    public static void main(String[] args) throws IOException {
        Double avg;
        try (Stream<String> stream = Files.lines(Path.of(PATH))){
            avg = stream.mapToInt(Integer::parseInt).average().getAsDouble();
            BufferedWriter writer = Files.newBufferedWriter(Path.of(PATH_OUT));
            writer.write(String.valueOf(avg));
            writer.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
