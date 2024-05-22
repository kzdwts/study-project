package com.kangyong.study.minio.core.config;

import io.minio.BucketExistsArgs;
import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import io.minio.UploadObjectArgs;
import io.minio.errors.MinioException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * test
 *
 * @author Kang Yong
 * @date 2024/5/21
 * @since 1.0.0
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class MinioConfigTest {

    @Autowired
    private MinioClient minioClient;

    @Test
    public void fileUploaderTest() throws IOException, NoSuchAlgorithmException, InvalidKeyException {
        try {
            // Make 'leadnews' bucket if not exist.
            boolean found =
                    minioClient.bucketExists(BucketExistsArgs.builder().bucket("leadnews").build());
            if (!found) {
                // Make a new bucket called 'asiatrip'.
                minioClient.makeBucket(MakeBucketArgs.builder().bucket("leadnews").build());
            } else {
                System.out.println("Bucket 'leadnews' already exists.");
            }

            // Upload '/home/user/Photos/asiaphotos.zip' as object name 'asiaphotos-2015.zip' to bucket
            // 'asiatrip'.
            minioClient.uploadObject(
                    UploadObjectArgs.builder()
                            .bucket("leadnews")
                            .object("804.jpg")
                            .filename("E:\\temp\\804.jpg")
                            .build());
            System.out.println(
                    "'E:\\temp\\804.jpg' is successfully uploaded as "
                            + "object '804.jpg' to bucket 'leadnews'.");
        } catch (MinioException e) {
            System.out.println("Error occurred: " + e);
            System.out.println("HTTP trace: " + e.httpTrace());
        }

    }

}