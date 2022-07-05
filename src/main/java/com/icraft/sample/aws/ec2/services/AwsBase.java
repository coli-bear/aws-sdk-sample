package com.icraft.sample.aws.ec2.services;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;

public class AwsBase {
    public AWSCredentials getAwsCredentials(String accessKey, String secretKey) {
        return new BasicAWSCredentials(accessKey, secretKey);
    }

    public AWSCredentialsProvider getAwsCredentialsProvider(AWSCredentials credentials) {
        return new AWSStaticCredentialsProvider(credentials);
    }
}
