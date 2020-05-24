package com.mashup.srinee.user.service;

import com.mashup.srinee.user.domain.User;
import com.mashup.srinee.user.domain.UserRepository;
import com.mashup.srinee.user.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public UserDTO signUp(UserDTO userDTO) {
        User user = userDTO.toDomain();
        user = userRepository.save(user);
        return userDTO.fromDomain(user);
    }
}
