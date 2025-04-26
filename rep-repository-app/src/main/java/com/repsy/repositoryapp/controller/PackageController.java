package com.repsy.repositoryapp.controller;

import com.repsy.repositoryapp.service.PackageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/")
public class PackageController {

    private final PackageService packageService;

    public PackageController(PackageService packageService) {
        this.packageService = packageService;
    }

    @PostMapping("{packageName}/{version}")
    public ResponseEntity<String> uploadPackage(
            @PathVariable String packageName,
            @PathVariable String version,
            @RequestParam("package") MultipartFile repFile,
            @RequestParam("meta") MultipartFile metaFile
    ) throws Exception {
        packageService.deployPackage(packageName, version, repFile, metaFile);
        return ResponseEntity.ok("Package deployed successfully.");
    }
}


