//package com.freemiumwear.config;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
//import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
//import software.amazon.awssdk.regions.Region;
//import software.amazon.awssdk.services.ses.SesClient;
//import software.amazon.awssdk.services.sqs.SqsClient;
//
//@Configuration
//public class AwsConfig {
//
//    @Value("${aws.region}")
//    private String region;
//
//    @Value("${aws.ses.access-key}")
//    private String accessKey;
//
//    @Value("${aws.ses.secret-key}")
//    private String secretKey;
//
//
//    @Bean
//    public SqsClient sqsClient() {
//        return SqsClient.builder()
//                .region(Region.of(region))
//                .build();
//    }
//
//    @Bean
//    public SesClient sesClient() {
//        return SesClient.builder().region(Region.AP_SOUTH_1)
//                .credentialsProvider(StaticCredentialsProvider.create(AwsBasicCredentials.create(accessKey, secretKey)))
//                .build();
//    }
//}
