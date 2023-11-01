package ru.otus.controlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.otus.model.UserRegistrationRequest;
import ru.otus.service.UserService;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    @GetMapping("/registration")
    public String registrationPage() {
        return "registration.html";
    }

    @PostMapping("/registration")
    @ResponseBody
    public ResponseEntity<String> registerUser(@RequestBody UserRegistrationRequest request) {
        try {
            userService.registerUser(request.getUsername(), request.getPassword());
            return ResponseEntity.ok("Регистрация прошла успешно");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Registration error: " + e.getMessage());
        }
    }
}
