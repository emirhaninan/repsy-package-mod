package com.repsy.repositoryapp.service;

import com.repsy.repositoryapp.entity.PackageEntity;
import com.repsy.repositoryapp.repository.PackageRepository;
import com.repsy.storage.StorageService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@Service
public class PackageService {

    private final StorageService storageService;
    private final PackageRepository packageRepository;

    public PackageService(StorageService storageService, PackageRepository packageRepository) {
        this.storageService = storageService;
        this.packageRepository = packageRepository;
    }

    public void deployPackage(String packageName, String version, MultipartFile repFile, MultipartFile metaFile) throws IOException {
        String id = UUID.randomUUID().toString();
        String packagePath = packageName + "/" + version + "/package.rep";
        String metaPath = packageName + "/" + version + "/meta.json";

        storageService.upload(packagePath, repFile.getInputStream());
        storageService.upload(metaPath, metaFile.getInputStream());

        PackageEntity packageEntity = new PackageEntity(id, packageName, version, metaPath, packagePath);
        packageRepository.save(packageEntity);
    }
}
