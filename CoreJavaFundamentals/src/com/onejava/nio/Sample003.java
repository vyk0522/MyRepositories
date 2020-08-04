package com.onejava.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Sample003 {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("D:\\1JavaOneWork\\MyRepositories");
        Stream<Path> stream = Files.walk(path);
        System.out.println(stream.count());

        long directoryCount = Files.walk(path).filter(e -> Files.isDirectory(e)).count();
        long filesCount = Files.walk(path).filter(e -> Files.isRegularFile(e)).count();
        System.out.println(directoryCount);
        System.out.println(filesCount);
    }
}
