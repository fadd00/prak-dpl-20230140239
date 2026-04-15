package com.tugas.deploy.controller;

import com.tugas.deploy.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    private static List<User> userList = new ArrayList<>();

    @GetMapping("/")
    public String index() {
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login() {
        // Simplified login, always redirect to home
        return "redirect:/home";
    }

    @GetMapping("/home")
    public String showHomePage(Model model) {
        model.addAttribute("users", userList);
        return "home";
    }

    @GetMapping("/form")
    public String showFormPage(Model model) {
        model.addAttribute("user", new User());
        return "form";
    }

    @PostMapping("/form")
    public String submitForm(@ModelAttribute User user) {
        userList.add(user);
        return "redirect:/home";
    }

    @GetMapping("/logout")
    public String logout() {
        return "redirect:/login";
    }
}
