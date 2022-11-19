package com.erdem.dockerizedcrud.service;


import com.erdem.dockerizedcrud.model.Role;
import com.erdem.dockerizedcrud.model.User;
import com.erdem.dockerizedcrud.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;


@Service
public class UserService implements IUserService
{
    @Autowired
private IUserRepository userRepository;
@Autowired
private PasswordEncoder passwordEncoder;



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
    public void changeRole(Role newRole, String username) {

    }

    @Override
    public List<User> findAllUsers()
    {
        return userRepository.findAll();
    }
}
