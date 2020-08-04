package com.onejava.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.Instant;
import java.util.stream.Stream;

public class Sample005_Basics {
    public static void main(String[] args) throws IOException {
        Path path1 = Paths.get("src\\com\\onejava\\nio\\files\\read.txt");
        Path path2 = Paths.get("src\\com\\onejava\\nio\\files\\write.txt");
        Path path3 = Paths.get("D:\\1JavaOneWork\\MyRepositories");

        boolean exists = Files.exists(path1);
        boolean sameFile = Files.isSameFile(path1, path2); // try catch required. It does not compare content
        System.out.println(exists);
        System.out.println(sameFile);

        Instant twoHoursAgo = Instant.now().minus(Duration.ofHours(1));
        Stream<Path> pathStream = Files
                .find(path3, 3, (path, attributes) -> attributes.creationTime().toInstant().isAfter(twoHoursAgo));

        pathStream.forEach(System.out::println);


    }
}
