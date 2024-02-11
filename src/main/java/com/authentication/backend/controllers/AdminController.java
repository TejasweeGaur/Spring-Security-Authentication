package com.authentication.backend.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller class for handling admin-related operations.
 * This class is designed to provide endpoints specifically for admin access to
 * the Spring Boot application.
 * It may include operations such as managing users, configuring application
 * settings, etc.
 */
@RestController
@RequestMapping("/api/admin")
@CrossOrigin("*")
public class AdminController {

    @GetMapping("/")
    public String testPath() {
        return "You have reached Admin Controller. Congratulations you have Admin Level Access !!!";
    }
}
