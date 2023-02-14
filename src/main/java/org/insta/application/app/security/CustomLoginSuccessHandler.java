package org.insta.application.app.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
CustomLoginSuccessHandler는 AuthenticationProvider를 통해 인증이 성공될 경우 처리되는데,
/index 요청으로 redirect되도록 해주었다.
그리고 토큰을 사용하지 않고 세션을 활용하는 지금 예제같은 경우에는 성공하여 반환된 Authentication 객체를 SecurityContextHolder의 Contetx에 저장해주어야 한다.
나중에 사용자의 정보를 꺼낼 경우에도 SecurityContextHolder의 context에서 조회하면 된다.
 */
public class CustomLoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException {
        SecurityContextHolder.getContext().setAuthentication(authentication);
        response.sendRedirect("/about");
    }

}