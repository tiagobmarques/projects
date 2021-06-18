package com.bmarques.tax;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import java.util.Optional;

@Configuration
@EnableDynamoDBRepositories(basePackages = "com.bmarques.tax.repository")
public class DynamoDbConfiguration {

    private final Environment env;

    public DynamoDbConfiguration(Environment env) {
        this.env = env;
    }

    @Bean
    public AmazonDynamoDB amazonDynamoDB() {

        return AmazonDynamoDBClientBuilder
                .standard()
                .withEndpointConfiguration(
                        new AwsClientBuilder.EndpointConfiguration(
                                "dynamodb.us-east-1.amazonaws.com",
                                "us-east-1"
                        )
                )
                .withCredentials(
                        new AWSStaticCredentialsProvider(amazonAWSCredentials())
                )
                .build();
    }

    @Bean
    public AWSCredentials amazonAWSCredentials() {

        String accessKey = env.getProperty("cloud.aws.credentials.access-key");
        String secretKey = env.getProperty("cloud.aws.credentials.secret-key");

        return new BasicAWSCredentials(
                accessKey, secretKey);
    }

}