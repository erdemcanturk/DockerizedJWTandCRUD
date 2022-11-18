package com.erdem.dockerizedcrud.service;


import com.erdem.dockerizedcrud.model.User;
import com.erdem.dockerizedcrud.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Service
public class UserService implements IUserService
{

  IUserRepository userRepository;


  PasswordEncoder passwordEncoder;

    @Override
    public User saveUser(User user)
    {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setCreateTime(LocalDateTime.now());
        return userRepository.save(user);
    }

    @Override
    public Optional<User> findBUsername(String username)
    {
        return userRepository.findByUsername(username);
    }

    @Override
    public List<User> findAllUsers()
    {
        return userRepository.findAll();
    }
}
