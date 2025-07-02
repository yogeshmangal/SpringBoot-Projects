# 🗂️ Spring Boot S3 File Upload Service (LocalStack)

This Spring Boot application provides REST APIs to **upload, download, list**, and **delete files** in an **S3-compatible storage**.  
It uses **LocalStack** to simulate AWS S3 locally, allowing development and testing without using actual AWS infrastructure.

---

## 🛠️ Setup Steps

### ✅ 1. Start LocalStack

You can start LocalStack using Docker:

```bash
localstack start -d
```

---

### ✅ 2. Create an S3 Bucket in LocalStack

```bash
aws --endpoint-url=http://localhost:4566 s3 mb s3://my-local-bucket
```

---

### ✅ 3. Verify Bucket and Files

#### 🪣 List all buckets:

```bash
aws --endpoint-url=http://localhost:4566 s3 ls
```

#### 📄 List all files in a specific bucket:

```bash
aws --endpoint-url=http://localhost:4566 s3 ls s3://my-local-bucket/
```

---

## 📚 Swagger API Documentation

This project includes Swagger UI for easy testing and exploration of the REST endpoints.

### ✅ Access Swagger UI

Once the Spring Boot application is running, open your browser and go to:

```
http://localhost:8080/swagger-ui/index.html
```

You will see a user-friendly interface to interact with the upload, download, list, and delete APIs.

---

## 🧪 API Endpoints

| Method | Endpoint                | Description              |
|--------|-------------------------|--------------------------|
| `POST` | `/upload`               | Upload a file            |
| `GET`  | `/download/{filename}`  | Download a file          |
| `GET`  | `/list`                 | List all files in bucket |
| `DELETE` | `/delete/{filename}` | Delete a file            |

---

## 🧑‍💻 Author
**Yogesh Mangal**