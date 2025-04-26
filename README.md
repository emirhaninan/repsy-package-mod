
# Repsy Package API![image](https://github.com/user-attachments/assets/e05ca88b-2c25-4297-9d4d-c9edbe515422)


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
## 🌐 API Endpoints

| Method | Endpoint                               | Description                     |
|:------:|----------------------------------------|---------------------------------|
| POST   | `/{packageName}/{version}`             | Upload a new package and metadata. |
| GET    | `/download/{packageName}/{version}/{filename}` | Download a specific file from a package. |

---

## Running the Application

### Local Run

```bash
# Compile all modules
mvn clean install

# Package Spring Boot app
cd rep-repository-app
mvn package

# Run the app
java -jar target/rep-repository-app-1.0.0.jar
```

### 🐳 Run with Docker Compose

```bash
docker-compose up --build
