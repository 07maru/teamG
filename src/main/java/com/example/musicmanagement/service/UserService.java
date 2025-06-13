package com.example.musicmanagement.service;

import com.example.musicmanagement.entity.User;
import com.example.musicmanagement.form.UserForm;
import com.example.musicmanagement.repository.UserRepository;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder){
        this.userRepository =userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void createUser(UserForm userForm) throws DuplicateKeyException{
        if (userRepository.existsByUsername(userForm.getUsername())){
            throw new DuplicateKeyException("ユーザ名は既に存在します: " + userForm.getUsername());

        }

        User user = new User();
        user.setUsername(userForm.getUsername());

        String hashedPassword = passwordEncoder.encode(userForm.getPassword());
        user.setPassword(hashedPassword);

        userRepository.insertUser(user);
    }
}
