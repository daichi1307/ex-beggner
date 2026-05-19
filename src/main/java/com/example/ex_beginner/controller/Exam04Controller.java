package com.example.ex_beginner.controller;

import com.example.ex_beginner.domai.User;
import com.example.ex_beginner.form.UserForm;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exam04")
public class Exam04Controller {
    @GetMapping("")
    public String index(UserForm form) {
        return "exam04";
    }

    @PostMapping("/input")
    public String inpit(
            @Validated UserForm form,
            BindingResult result,
            Model model
    ) {
        if (result.hasErrors()) {
            return index(form);
        }
        User user = new User();
//        user.setName(form.getName());
//        user.setAge(form.getAge());
//        user.setComment(form.getComment());
        BeanUtils.copyProperties(form, user);
        user.setAge(Integer.parseInt(form.getAge()));
        model.addAttribute("user", user);
        return "exam04-result.html";
    }
}
