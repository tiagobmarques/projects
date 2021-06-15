package com.bmarques.invoice.domain.config;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sqs.AmazonSQSAsync;
import com.amazonaws.services.sqs.AmazonSQSAsyncClientBuilder;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import java.util.Optional;

@Configuration
public class SQSConfig {

    private final Environment env;

    public SQSConfig(Environment env) {
        this.env = env;
    }

    @Bean
    public QueueMessagingTemplate queueMessagingTemplate() {
        return new QueueMessagingTemplate(amazonSQSAsync());
    }

    public AmazonSQSAsync amazonSQSAsync() {
        String accessKey = Optional.ofNullable(env.getProperty("cloud.aws.credentials.access-key"))
                .orElse(System.getenv("AWS_ACCESS_KEY"));
        String secretKey = Optional.ofNullable(env.getProperty("cloud.aws.credentials.secret-key"))
                .orElse(System.getenv("AWS_SECRET_KEY"));

        return AmazonSQSAsyncClientBuilder
                .standard()
                .withRegion(Regions.US_EAST_1)
                .withCredentials(new AWSStaticCredentialsProvider(
                        new BasicAWSCredentials(accessKey, secretKey)))
                .build();
    }
}

