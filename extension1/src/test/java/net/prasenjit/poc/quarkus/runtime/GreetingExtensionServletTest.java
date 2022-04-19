package net.prasenjit.poc.quarkus.runtime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class GreetingExtensionServletTest {

    private GreetingExtensionServlet servlet;

    @BeforeEach
    public void setup() {
        servlet = new GreetingExtensionServlet();
    }

    @Test
    void doGet() throws IOException {
        HttpServletRequest req = mock(HttpServletRequest.class);
        HttpServletResponse resp = mock(HttpServletResponse.class);
        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintWriter pr = new PrintWriter(out);
        when(resp.getWriter()).thenReturn(pr);
        servlet.doGet(req, resp);

        assertEquals("", out.toString());
    }
}
