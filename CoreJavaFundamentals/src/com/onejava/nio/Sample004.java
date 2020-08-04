package com.onejava.nio;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Sample004 {
    public static void main(String[] args) {
        Path readPath = Paths.get("src\\com\\onejava\\nio\\files\\read.txt");
        Path writePath = Paths.get("src\\com\\onejava\\nio\\files\\write.txt");

        readWriteFile(readPath, writePath);
        System.out.println("Done!!");
    }

    public static void readWriteFile(Path readPath, Path writePath){
        try(Stream<String> lines = Files.lines(readPath);
            BufferedWriter writer = Files.newBufferedWriter(writePath)) {
            //lines.forEach(e -> writeContent(writer, e));
            String content = lines.collect(Collectors.joining("\n"));
            writeContent(writer, content);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void writeContent(BufferedWriter writer, String e) {
        try {
            writer.write(e);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
