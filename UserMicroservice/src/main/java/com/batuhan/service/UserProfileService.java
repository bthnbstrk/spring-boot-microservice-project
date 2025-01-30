package com.batuhan.service;

import com.batuhan.document.UserProfile;
import com.batuhan.dto.request.CreateUserRequestDto;
import com.batuhan.repository.UserProfileRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserProfileService {
    private final UserProfileRepository repository;
    private final CacheManager cacheManager;
    public void create(CreateUserRequestDto dto) {
        repository.save(UserProfile.builder()
                .authId(dto.getAuthId())
                .userName(dto.getUsername())
                .email(dto.getEmail())
                .build());
    }

    public List<UserProfile> getAll() {
        return repository.findAll();
    }

    @Cacheable("upper-case")
    public String upperName(String name) {
        return name.toUpperCase();
    }

    public void clearCache(){
        cacheManager.getCache("upper-case").clear();
    }
}
