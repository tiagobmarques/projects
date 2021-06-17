package com.bmarques.tax;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestStreamHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

@Component
@Slf4j
public class UpperCaseStringHandler implements RequestStreamHandler {

    @Override
    public void handleRequest(InputStream input, OutputStream output, Context context) throws IOException {
        String inputStream = IOUtils.toString(input, StandardCharsets.UTF_8);
        log.info("This is entrypoint!");
        log.info("This is entrypoint, New!");
        log.info(inputStream);
        output.write(("Hello World - " + inputStream).getBytes());
    }
}