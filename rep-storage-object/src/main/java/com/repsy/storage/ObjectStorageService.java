package com.repsy.storage.objectstorage;

import java.io.InputStream;

public interface ObjectStorageService {
    void save(String path, InputStream inputStream);
    InputStream load(String path);
}
