package com.example.clientsservicepd12.ui.controllers;

import com.example.clientsservicepd12.models.User;
import com.example.clientsservicepd12.services.data.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {
	@Autowired
	private UserService userService;

	@PostMapping("registerForm")
	String registerForm(@ModelAttribute("user") User user) {
		user = userService.save(user);
		System.err.println("registerForm " + user);
		return "redirect:";
	}
}
