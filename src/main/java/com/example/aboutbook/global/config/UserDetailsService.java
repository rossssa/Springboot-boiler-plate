package com.example.aboutbook.global.config;

import com.example.aboutbook.global.exception.ApiException;
import com.example.aboutbook.global.exception.ApiResponseStatus;
import com.example.aboutbook.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    private final UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws ApiException {
        return userRepository.findByEmail(username).orElseThrow(
                () -> new ApiException(ApiResponseStatus.BAD_REQUEST));
    }
}
