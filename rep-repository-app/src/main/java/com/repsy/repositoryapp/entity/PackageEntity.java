package com.repsy.repositoryapp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "packages")
public class PackageEntity {

    @Id
    private String id;

    private String packageName;
    private String version;
    private String metaJsonPath;
    private String packageRepPath;

    // Constructors
    public PackageEntity() {}

    public PackageEntity(String id, String packageName, String version, String metaJsonPath, String packageRepPath) {
        this.id = id;
        this.packageName = packageName;
        this.version = version;
        this.metaJsonPath = metaJsonPath;
        this.packageRepPath = packageRepPath;
    }

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getPackageName() { return packageName; }
    public void setPackageName(String packageName) { this.packageName = packageName; }

    public String getVersion() { return version; }
    public void setVersion(String version) { this.version = version; }

    public String getMetaJsonPath() { return metaJsonPath; }
    public void setMetaJsonPath(String metaJsonPath) { this.metaJsonPath = metaJsonPath; }

    public String getPackageRepPath() { return packageRepPath; }
    public void setPackageRepPath(String packageRepPath) { this.packageRepPath = packageRepPath; }
}
