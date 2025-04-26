

# Repsy Package Mod

A complete modular Spring Boot application designed for package storage and retrieval using PostgreSQL and backends like Filesystem, MinIO.

---

## Structure

**Multi-module Maven** setup:

- `rep-storage-api/` — Defines the generic `StorageService` interface.
- `rep-storage-filesystem/` — Filesystem-based implementation of `StorageService`.
- `rep-storage-object/` — MinIO / Object Storage implementation of `StorageService`.
- `rep-repository-app/` — Main Spring Boot Application (package management backend).

---

## Tech Stack

- Java 21
- Spring Boot 3.2.3
- Maven
- PostgreSQL
- Hibernate JPA
- Docker + Docker Compose
- MinIO (for object storage)
- HikariCP (for database connection pooling)
- Lombok
- JAXB (for XML bindings when needed, Eclipse)

---

## Features

- Upload and store packages (binary `.rep` and `meta.json` files).
- Choose storage backend dynamically (Filesystem or MinIO).
- Dockerized setup for fast local development.
- Clean architecture with **StorageService** abstraction.
- Production-ready multi-module Maven build.
- Fully integrated PostgreSQL database.
- Clean API for uploading and downloading packages.

---

## 🐳 Run with Docker Compose

```bash
docker-compose up --build
