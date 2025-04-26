package com.repsy.repositoryapp.config;

import com.repsy.storage.StorageService;
import com.repsy.storage.filesystem.FileSystemStorageService;
import com.repsy.storage.objectstorage.MinioObjectStorageService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StorageConfig {

    @Value("${storage.strategy}")
    private String storageStrategy;

    @Value("${storage.upload-path}")
    private String uploadPath;

    @Value("${storage.access-key:}")
    private String accessKey;

    @Value("${storage.secret-key:}")
    private String secretKey;

    @Value("${storage.endpoint:}")
    private String endpoint;

    @Value("${storage.bucket-name:}")
    private String bucketName;

    @Bean
    public StorageService storageService() {
        if ("object-storage".equals(storageStrategy)) {
            return new MinioObjectStorageService(accessKey, secretKey, endpoint, bucketName);
        } else {
            return new FileSystemStorageService(uploadPath);
        }
    }
}
