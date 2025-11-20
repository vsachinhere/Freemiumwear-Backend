//package com.freemiumwear.config;
//
//import com.amazonaws.services.s3.AmazonS3;
//import com.amazonaws.services.s3.model.S3Object;
//import org.springframework.stereotype.Service;
//
//@Service
//public class S3Service {
//    private final AmazonS3 s3Client;
//
//    public S3Service(AmazonS3 s3Client) {
//        this.s3Client = s3Client;
//    }
//
//    public S3Object getFile(String bucketName, String fileName) {
//        return s3Client.getObject(bucketName, fileName);
//    }
//}