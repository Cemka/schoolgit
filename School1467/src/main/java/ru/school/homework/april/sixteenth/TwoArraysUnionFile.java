package ru.school.homework.april.sixteenth;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TwoArraysUnionFile{
    public static void main(String[] args) throws IOException {
        String firArr;
        String secArr;
        firArr = Files.lines(Paths.get("firarr.txt"), StandardCharsets.UTF_8).collect(Collectors.joining());
        secArr = Files.lines(Paths.get("secarr.txt"), StandardCharsets.UTF_8).collect(Collectors.joining());

        String[] arr1;
        String[] arr2;
        int[] arr3;
        arr1 = firArr.split(" ");
        arr2 = secArr.split(" ");

        arr3 = IntStream.concat(IntStream.of(Arrays.stream(arr1).mapToInt(Integer::parseInt).toArray()),
                IntStream.of(Arrays.stream(arr2).mapToInt(Integer::parseInt).toArray())).toArray();

        Arrays.stream(arr3).sorted().forEach(System.out::println);
    }
}
