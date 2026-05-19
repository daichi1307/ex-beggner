package com.example.ex_beginner.controller;

import com.example.ex_beginner.domai.User;
import com.example.ex_beginner.form.UserForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exam04")
public class Exam04Controller {
    @GetMapping("")
    public String index(UserForm userForm) {
        return "exam04";
    }

    @PostMapping("/input")
    public String inpit(UserForm form, Model model) {
        User user = new User();
        user.setName(form.getName());
        user.setAge(form.getAge());
        user.setComment(form.getComment());
        model.addAttribute(user);
        return "eam04-result.html";
    }
}
