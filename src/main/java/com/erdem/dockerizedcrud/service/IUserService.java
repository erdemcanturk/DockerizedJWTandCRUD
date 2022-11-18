package com.erdem.dockerizedcrud.service;


import com.erdem.dockerizedcrud.model.User;

import java.util.List;
import java.util.Optional;

public interface IUserService
{
    User saveUser(User user);

    Optional<User> findBUsername(String username);

    List<User> findAllUsers();
}
