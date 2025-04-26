package com.repsy.repositoryapp.repository;

import com.repsy.repositoryapp.entity.PackageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PackageRepository extends JpaRepository<PackageEntity, String> {
}
