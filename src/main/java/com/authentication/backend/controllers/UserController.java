package com.authentication.backend.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controller class for handling user-related operations.
 * This class is responsible for fetching user details required by Spring
 * Security
 * to enable user authentication and access control within the Spring Boot
 * application.
 */
@RestController
@RequestMapping("/api/user")
@CrossOrigin("*")
public class UserController {

    @GetMapping("/")
    public String testPath() {
        return "You have reached User Controller. Congratulations you have User Level Access !!!";
    }

}
