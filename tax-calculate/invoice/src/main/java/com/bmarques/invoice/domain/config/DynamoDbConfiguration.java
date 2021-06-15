package com.bmarques.invoice.domain.config;

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
@EnableDynamoDBRepositories(basePackages = "com.bmarques.invoice.domain.invoice")
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
        String accessKey = Optional.ofNullable(env.getProperty("cloud.aws.credentials.access-key"))
                .orElse(System.getenv("AWS_ACCESS_KEY"));
        String secretKey = Optional.ofNullable(env.getProperty("cloud.aws.credentials.secret-key"))
                .orElse(System.getenv("AWS_SECRET_KEY"));

        return new BasicAWSCredentials(
                accessKey, secretKey);
    }

}