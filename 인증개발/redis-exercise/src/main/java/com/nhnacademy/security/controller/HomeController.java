package com.nhnacademy.security.controller;

import java.util.Objects;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;

// TODO #5: `/` 페이지에서는 `SESSION` 쿠키에 저장되어 있는 sessionId를 가지고 redis 에 조회해서
//          로그인한 사용자의 username 과 authority 를 가져와 화면에 출력할 수 있도록 model attribute에 넣어줍니다.
@Controller
public class HomeController {
    private final RedisTemplate<String, Object> redisTemplate;

    public HomeController(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }


    @GetMapping("/")
    public String home(@CookieValue(name = "SESSION", required = false) String sessionId,
                       Model model) {
        if (Objects.isNull(sessionId)) {
            return "redirect:/login";
        } else {
            String username = (String) redisTemplate.opsForHash().get(sessionId, "username");
            String authority = (String) redisTemplate.opsForHash().get(sessionId, "authority");

            model.addAttribute("username", username);
            model.addAttribute("authority", authority);

            return "home";
        }
    }

}
