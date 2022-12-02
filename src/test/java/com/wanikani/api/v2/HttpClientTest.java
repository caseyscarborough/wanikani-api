package com.wanikani.api.v2;

import com.wanikani.api.v2.exception.WaniKaniException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HttpClientTest {
    private static final String API_KEY = System.getenv("WANIKANI_API_KEY");
    private HttpClient client;

    @BeforeEach
    void setUp() throws Exception {
        // Skip tests if the API key is not set
        Assumptions.assumeTrue(API_KEY != null);

        client = new HttpClient(API_KEY);
    }

    @Test
    void testErrorHandling() {
        Assertions.assertThrows(WaniKaniException.class, () -> client.get("/thisisa404"), "404 Not Found");
    }
}
