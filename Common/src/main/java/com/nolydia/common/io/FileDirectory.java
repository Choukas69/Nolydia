package com.nolydia.common.io;

import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class FileDirectory {

    private final List<Path> files = new ArrayList<>();

    @Inject
    public FileDirectory(@Assisted Path rootPath) {
        try (Stream<Path> walk = Files.walk(rootPath)) {
            walk.forEach(path -> {
                File file = path.toFile();
                if (!file.isDirectory() && !file.isHidden()) {
                    files.add(path);
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Path> listDirectory() {
        return files;
    }
}
