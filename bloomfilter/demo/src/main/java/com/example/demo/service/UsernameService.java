package com.example.demo.service;

import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UsernameService {

    private final UserRepository userRepository;
    private final BloomFilterService bloomFilterService;

    public UsernameService(UserRepository userRepository,
                           BloomFilterService bloomFilterService) {
        this.userRepository = userRepository;
        this.bloomFilterService = bloomFilterService;
    }

    public boolean isAvailable(String username) {

        if(!bloomFilterService.mightExist(username)) {

            System.out.println(
                    "Bloom Filter says not present"
            );

            return true;
        }

        System.out.println(
                "Bloom Filter says maybe present"
        );

        return !userRepository.existsByUsername(username);
    }
}