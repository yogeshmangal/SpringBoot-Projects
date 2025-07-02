package com.s3filemanager.s3_file_manager.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.*;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class S3Service {

  private final S3Client s3Client;

  @Value("${aws.s3.bucket-name}")
  private String bucketName;

  public S3Service(S3Client s3Client) {
    this.s3Client = s3Client;
  }

  public void uploadFile(MultipartFile file) throws IOException {
    try {
      s3Client.putObject(
          PutObjectRequest.builder().bucket(bucketName).key(file.getOriginalFilename()).build(),
          RequestBody.fromBytes(file.getBytes()));
    } catch (Exception ex) {
      throw new RuntimeException(ex);
    }
  }

  public List<String> listFiles() {
    ListObjectsV2Response response =
        s3Client.listObjectsV2(ListObjectsV2Request.builder().bucket(bucketName).build());
    return response.contents().stream().map(S3Object::key).collect(Collectors.toList());
  }

  public byte[] downloadFile(String key) throws IOException {
    GetObjectResponse response;
    return s3Client
        .getObject(GetObjectRequest.builder().bucket(bucketName).key(key).build())
        .readAllBytes();
  }

  public void deleteFile(String key) {
    s3Client.deleteObject(DeleteObjectRequest.builder().bucket(bucketName).key(key).build());
  }
}
