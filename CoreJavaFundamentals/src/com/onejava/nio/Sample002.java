package com.onejava.nio;

import com.onejava.nio.model.Person;
import lombok.AllArgsConstructor;
import lombok.ToString;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Sample002 {
    public static void main(String[] args) {
        Path path1 = Paths.get("src\\com\\onejava\\nio\\files\\read.csv");
        Path path2 = Paths.get("src\\com\\onejava\\nio\\files\\write.txt");

        try (Stream<String> lines = Files.lines(path1);
             BufferedWriter writer = Files.newBufferedWriter(path2)) {
               lines.filter(e -> ! e.startsWith("#"))
                    .flatMap(Sample002::lineToPerson)
                    .forEach(e -> writeTofile(writer, e));
        }
        catch (IOException ex){

        }
        System.out.println("Done!!");

    }

    private static void writeTofile(BufferedWriter writer, Person e) {
        try {
            writer.write(String.valueOf(e) + "\n");
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }


    /*
    If line format is not correct. It returns empty stream
     */
    private static Stream<Person> lineToPerson(String line){
        try {
            String[] elements = line.split(",");
            String name = elements[0];
            int age = Integer.parseInt(elements[1]);
            String city = elements[2];

            Person person = new Person(name, age, city);
            return Stream.of(person);
        } catch (Exception e) {

        }
        return Stream.empty();
    }


}
