package com.onejava.nio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Sample001 {
    public static void main(String[] args) {
        Path path1 = Paths.get("src\\com\\onejava\\nio\\files\\read.txt");
        Path path2 = Paths.get("src\\com\\onejava\\nio\\files\\write.txt");
        readFile(path1);
        writeFile2(path2);
        System.out.println("done!!");
    }

    private static void writeFile(Path path) {
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            writer.write("Hello World!!!");
        }
        catch (IOException ex){

        }
    }

    /*
    Format using PrintWriter
     */
    private static void writeFile2(Path path) {
        try (BufferedWriter writer1 = Files.newBufferedWriter(path);
             BufferedWriter writer2 = new BufferedWriter(writer1);
             PrintWriter printWriter = new PrintWriter(writer2)) {
            writer1.write("Hello World!!!");
            printWriter.printf("\nUser = %s\n", "User1");
        }
        catch (IOException ex){

        }
    }

    /*
      For different Charsets, pass StandardCharsets arg
     */
    private static void readFile(Path path) {
        try (BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.ISO_8859_1)) {
            String line = reader.readLine();
            while (line != null){
                System.out.println(line);
                line = reader.readLine();
            }
        }
        catch (IOException ex){

        }
    }
}
