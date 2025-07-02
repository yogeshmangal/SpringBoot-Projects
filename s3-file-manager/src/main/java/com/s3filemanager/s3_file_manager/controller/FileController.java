package com.s3filemanager.s3_file_manager.controller;

import com.s3filemanager.s3_file_manager.service.S3Service;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/files")
public class FileController {

  private final S3Service s3Service;

  public FileController(S3Service s3Service) {
    this.s3Service = s3Service;
  }

  @PostMapping("/upload")
  public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file)
      throws IOException {
    s3Service.uploadFile(file);
    return ResponseEntity.ok("File uploaded successfully");
  }

  @GetMapping
  public ResponseEntity<List<String>> listFiles() {
    return ResponseEntity.ok(s3Service.listFiles());
  }

  @GetMapping("/{key}")
  public ResponseEntity<byte[]> download(@PathVariable String key) throws IOException {
    byte[] content = s3Service.downloadFile(key);
    return ResponseEntity.ok()
        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + key)
        .contentType(MediaType.APPLICATION_OCTET_STREAM)
        .body(content);
  }

  @DeleteMapping("/{key}")
  public ResponseEntity<String> delete(@PathVariable String key) {
    s3Service.deleteFile(key);
    return ResponseEntity.ok("File deleted successfully!");
  }
}
