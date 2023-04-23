package com.nhnacademy.board.controller;

import com.nhnacademy.board.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserRegisterController {

//    @PostMapping("/register")
//    public String register(@Valid )

    @GetMapping("/register")
    public String registerForm(Model model) {
        model.addAttribute(new User());
        return "user/register";
    }
}
