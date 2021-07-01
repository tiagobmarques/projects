package com.banking.cardinsurance.infrastructure;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import org.socialsignin.spring.data.dynamodb.config.EnableDynamoDBAuditing;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import java.util.Optional;

@Configuration
@EnableDynamoDBRepositories(basePackages = "com.banking.cardinsurance.infrastructure")
@EnableDynamoDBAuditing
public class DynamoDbConfiguration {

    private final Environment env;

    public DynamoDbConfiguration(Environment env) {
        this.env = env;
    }

    @Bean
    public AmazonDynamoDB amazonDynamoDB() {

        String endpoint = env.getProperty("cloud.aws.credentials.service-endpoint");
        String region = env.getProperty("cloud.aws.credentials.signing");

        return AmazonDynamoDBClientBuilder
                .standard()
                .withEndpointConfiguration(
                        new AwsClientBuilder.EndpointConfiguration(
                                endpoint,
                                region
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