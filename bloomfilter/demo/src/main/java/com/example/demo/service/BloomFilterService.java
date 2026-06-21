package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.List;

@Service
public class BloomFilterService {

    private final UserRepository userRepository;

    private BloomFilter<String> bloomFilter;

    public BloomFilterService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostConstruct
    public void loadBloomFilter() {

        bloomFilter = BloomFilter.create(
                Funnels.stringFunnel(StandardCharsets.UTF_8),
                100000,
                0.01
        );

        List<User> users = userRepository.findAll();

        for(User user : users) {
            bloomFilter.put(user.getUsername());
        }

        System.out.println("Bloom Filter Loaded");
    }

    public boolean mightExist(String username) {
        return bloomFilter.mightContain(username);
    }

    public void addUsername(String username) {
        bloomFilter.put(username);
    }
}