package com.repsy.storage;

import java.io.IOException;
import java.io.InputStream;

public interface StorageService {
    void upload(String path, InputStream inputStream) throws IOException;
    InputStream download(String path) throws IOException;
}
