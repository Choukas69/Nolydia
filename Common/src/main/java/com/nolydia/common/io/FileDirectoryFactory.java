package com.nolydia.common.io;

import java.nio.file.Path;

public interface FileDirectoryFactory {

    FileDirectory createFileDirectory(Path path);
}
