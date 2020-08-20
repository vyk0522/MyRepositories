package com.onejava.nio;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sample006_Zip {
    public static void main(String[] args) {
        Path zipPath = Paths.get("src\\com\\onejava\\nio\\files\\data.zip");
        List data = Arrays.asList("aa", "bb", "cc");

        try (FileSystem zipFS = openZip(zipPath)) {
            copyToZipFS(zipFS);
            writeToFileInZip(zipFS, data);
        }
        catch (Exception ex){
            System.out.println(ex.getClass().getSimpleName() + " - " + ex.getMessage());
        }
        System.out.println("Done!!");
    }

    private static FileSystem openZip(Path zipPath) throws URISyntaxException, IOException {
        Map<String, String> providerProps = new HashMap<>();
        providerProps.put("create", "true");

        URI zipUri = new URI("jar:file", zipPath.toUri().getPath(), null );
        FileSystem zipFS = FileSystems.newFileSystem(zipUri, providerProps);

        return zipFS;
    }

    private static void copyToZipFS(FileSystem zipFS) throws IOException {
        Path sourceFile = Paths.get("src\\com\\onejava\\nio\\files\\read.txt");
        Path destFile = zipFS.getPath("/newFile1.txt");
        Files.copy(sourceFile, destFile, StandardCopyOption.REPLACE_EXISTING); //IOE
    }

    private static void writeToFileInZip(FileSystem zipFS, List data) throws IOException {
        Files.write(zipFS.getPath("/newFile2.txt"), data, Charset.defaultCharset(),
                StandardOpenOption.CREATE);
    }

}
