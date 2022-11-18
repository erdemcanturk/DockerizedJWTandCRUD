package com.erdem.dockerizedcrud.service;


import com.erdem.dockerizedcrud.model.User;

public interface IAuthenticationService
{
    String signInAndReturnJWT(User signInRequest);
}
