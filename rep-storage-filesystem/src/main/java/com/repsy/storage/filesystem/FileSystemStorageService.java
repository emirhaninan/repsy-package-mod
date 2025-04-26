package com.repsy.storage.filesystem;

import com.repsy.storage.StorageService;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.*;

public class FileSystemStorageService implements StorageService {

    private final Path rootPath;

    public FileSystemStorageService(String rootDir) {
        this.rootPath = Paths.get(rootDir);
    }

    @Override
    public void upload(String path, InputStream inputStream) throws IOException {
        Path targetPath = rootPath.resolve(path);
        Files.createDirectories(targetPath.getParent());
        Files.copy(inputStream, targetPath, StandardCopyOption.REPLACE_EXISTING);
    }

    @Override
    public InputStream download(String path) throws IOException {
        Path filePath = rootPath.resolve(path);
        return Files.newInputStream(filePath);
    }
}
