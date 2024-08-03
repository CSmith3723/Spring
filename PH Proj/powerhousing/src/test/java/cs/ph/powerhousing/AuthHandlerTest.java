package cs.ph.powerhousing;

import cs.ph.powerhousing.configs.AuthSuccessHandler;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.security.core.Authentication;

import java.io.IOException;

import static org.mockito.Mockito.*;

public class AuthHandlerTest {

    @Test
    public void testAuthenticationHandler() throws IOException, ServletException {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        FilterChain chain = mock(FilterChain.class);
        Authentication authentication = mock(Authentication.class);


        AuthSuccessHandler handler = new AuthSuccessHandler("/calculator");
        handler.onAuthenticationSuccess(request, response,chain, authentication);

        // Verify logging or behavior
        // e.g., verify that a redirect or other action occurs
    }
}
