package net.prasenjit.poc.quarkus.runtime;

import org.junit.jupiter.api.Test;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.core.UriInfo;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ReqFilterTest {

    @Test
    void filter() throws IOException {
        ReqFilter filter = new ReqFilter();
        ContainerRequestContext rc = mock(ContainerRequestContext.class);
        when(rc.getUriInfo()).thenReturn(mock(UriInfo.class));
        filter.filter(rc);
    }
}
