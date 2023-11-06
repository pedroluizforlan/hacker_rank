package com.hackerrank.datastructures.arrays;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class ResultJavaArraysDS {
    public static List<Integer> reverseArray(List<Integer> a) {
        List<Integer> arrReverse= new ArrayList<>();
        for(int i = a.size()-1; i >=0; i--) {
            arrReverse.add(a.get(i));
        }
        return arrReverse;
    }
}

public class SolutionJavaArraysDS {
    public static void main(String[] args) throws IOException {
        System.out.println("Teste");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> res = ResultJavaArraysDS.reverseArray(arr);

        bufferedWriter.write(
                res.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
