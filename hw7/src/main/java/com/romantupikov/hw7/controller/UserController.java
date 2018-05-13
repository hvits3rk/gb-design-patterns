package com.romantupikov.hw7.controller;

import com.romantupikov.hw7.entity.User;
import com.romantupikov.hw7.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/add")
    public String getUserForm(User user) {

        return "user/user_form";
    }

    @PostMapping("/add")
    public String addUser(User user) {
        userRepository.save(user);
        return "redirect:all";
    }

    @GetMapping("/{id}")
    public String userDetails(@PathVariable("id") Long id, Model model) {
        User user = userRepository.findById(id).get();
        model.addAttribute("user", user);
        return "user/user";
    }

    @GetMapping("/all")
    public String getAllUsers(Model model) {
        model.addAttribute("users", userRepository.findAll());

        return "user/user_list";
    }
}