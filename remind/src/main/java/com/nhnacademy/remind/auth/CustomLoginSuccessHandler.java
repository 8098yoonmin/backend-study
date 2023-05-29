package com.nhnacademy.remind.auth;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        //세션을 만들어 로그인한 사용자의 username을 세션에 저장
        HttpSession session = request.getSession();
        session.setAttribute("username", authentication.getName());

        //세션 아이디를 Session이라는 이름의 쿠키에 저장
        response.addCookie(new Cookie("SESSION", session.getId()));

        // 로그인 성공 후에는 '/' redirect
        response.sendRedirect("/index");
    }

}
