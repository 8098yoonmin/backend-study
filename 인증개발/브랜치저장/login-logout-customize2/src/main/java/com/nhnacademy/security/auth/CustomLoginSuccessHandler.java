package com.nhnacademy.security.auth;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

// TODO #3: login success handler 설정
public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication)
        throws IOException, ServletException {
        // TODO #4: 실습 - 세션을 만들어서 로그인한 사용자의 username을 세션에 저장
        HttpSession session = request.getSession();
        session.setAttribute("username", authentication.getName());

        // TODO #5: 실습 - 세션 아이디를 SESSION 이라는 이름의 쿠키에 저장
        Cookie cookie = new Cookie("SESSION", session.getId());
//        cookie.setDomain();
//        cookie.setMaxAge(2123);
        response.addCookie(cookie);

        // TODO #6: 실습 - 로그인 성공 후에는 `/`로 redirect
        response.sendRedirect("/");
    }

}
