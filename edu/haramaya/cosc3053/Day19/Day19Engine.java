package edu.haramaya.cosc3053.Day19;

import java.nio.file.Path;
import java.nio.file.Files;

public class Day19Engine {

    public static void main(String[] args) {

        Path myFile = Path.of("students.txt");

        System.out.println(Files.exists(myFile));
    }
}