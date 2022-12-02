package com.wanikani.api.v2;

import com.wanikani.api.v2.exception.WaniKaniException;
import org.junit.Assume;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class HttpClientTest {
    private static final String API_KEY = System.getenv("WANIKANI_API_KEY");
    @Rule
    public ExpectedException exception = ExpectedException.none();
    private HttpClient client;

    @Before
    public void setUp() throws Exception {
        // Skip tests if the API key is not set
        Assume.assumeTrue(API_KEY != null);

        client = new HttpClient(API_KEY);
    }

    @Test
    public void testErrorHandling() {
        exception.expect(WaniKaniException.class);
        exception.expectMessage("404 Not Found");
        client.get("/thisisa404");
    }
}
