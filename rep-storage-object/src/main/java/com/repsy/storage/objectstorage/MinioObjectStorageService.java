package com.repsy.storage.objectstorage;

import com.repsy.storage.StorageService;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import io.minio.GetObjectArgs;

import java.io.IOException;
import java.io.InputStream;

public class MinioObjectStorageService implements StorageService {

    private final MinioClient minioClient;
    private final String bucketName;

    public MinioObjectStorageService(String accessKey, String secretKey, String endpoint, String bucketName) {
        this.minioClient = MinioClient.builder()
                .credentials(accessKey, secretKey)
                .endpoint(endpoint)
                .build();
        this.bucketName = bucketName;
    }

    @Override
    public void upload(String path, InputStream inputStream) throws IOException {
        try {
            minioClient.putObject(
                    PutObjectArgs.builder()
                            .bucket(bucketName)
                            .object(path)
                            .stream(inputStream, -1, 10485760)
                            .contentType("application/octet-stream")
                            .build()
            );
        } catch (Exception e) {
            throw new IOException("Failed to upload file to MinIO", e);
        }
    }

    @Override
    public InputStream download(String path) throws IOException {
        try {
            return minioClient.getObject(
                    GetObjectArgs.builder()
                            .bucket(bucketName)
                            .object(path)
                            .build()
            );
        } catch (Exception e) {
            throw new IOException("Failed to download file from MinIO", e);
        }
    }
}
