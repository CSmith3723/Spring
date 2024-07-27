package cs.ph.powerhousing.controllers;

import cs.ph.powerhousing.entities.UserInfo;
import cs.ph.powerhousing.services.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Controller;

import java.io.IOException;

@Controller
public class PHAuthSuccessHandler implements AuthenticationSuccessHandler {
    private UserService userService;

    @Autowired
    public PHAuthSuccessHandler(UserService theUserService) {
        userService = theUserService;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse
            response, Authentication authentication)
            throws IOException, ServletException {

                System.out.println("In customAuthenticationSuccessHandler");
                String userName = authentication.getName();
                System.out.println("username=" + userName);
                UserInfo theUserInfo = userService.findByUsername(userName);

                // now place in the session
                HttpSession session = request.getSession();
                session.setAttribute("userinfo", theUserInfo);

                // forward to home page
                response.sendRedirect(request.getContextPath() + "/login-confirmation");
    }
}