package com.example.demo.controller;

import com.example.demo.dto.UsernameResponse;
import com.example.demo.service.UsernameService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/username")
public class UsernameController {

    private final UsernameService usernameService;

    public UsernameController(
            UsernameService usernameService) {
        this.usernameService = usernameService;
    }

    @GetMapping("/{username}")
    public UsernameResponse checkUsername(
            @PathVariable String username) {

        boolean available =
                usernameService.isAvailable(username);

        return new UsernameResponse(available);
    }
}