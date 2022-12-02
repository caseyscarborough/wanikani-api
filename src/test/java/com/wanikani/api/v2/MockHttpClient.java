package com.wanikani.api.v2;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.jupiter.api.Assumptions;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

/**
 * This class will cache API responses in src/test/resources to be used for
 * future API requests, allowing tests to be ran against previously recorded
 * responses.
 */
class MockHttpClient extends HttpClient {
    MockHttpClient(String apiKey) {
        super(apiKey);
    }

    @Override
    String get(String contextPath) {
        try {
            String hash = DigestUtils.md5Hex(contextPath.getBytes(StandardCharsets.UTF_8));
            File file = new File("src/test/resources/json/" + hash + ".json");
            if (file.exists()) {
                System.out.println("Found cached API response, returning JSON from " + file.getAbsolutePath());
                return Files.lines(Paths.get(file.getAbsolutePath())).collect(Collectors.joining(System.lineSeparator()));
            }

            System.out.println("Couldn't find cached file at path " + file.getAbsolutePath() + ", making API request if API key is present");
            Assumptions.assumeTrue(this.apiKey != null);
            String response = super.get(contextPath);
            Files.write(Paths.get(file.getAbsolutePath()), response.getBytes(StandardCharsets.UTF_8));
            return response;
        } catch (IOException e) {
            throw new RuntimeException("Found test file in src/test/resources/json but could not read the contents", e);
        }
    }
}
