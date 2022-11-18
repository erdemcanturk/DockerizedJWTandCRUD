package com.erdem.dockerizedcrud.service;

import com.erdem.dockerizedcrud.model.User;
import com.erdem.dockerizedcrud.security.UserPrincipal;
import com.erdem.dockerizedcrud.security.jwt.IJwtProvider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;




@Service
public class AuthenticationService implements IAuthenticationService
{

     AuthenticationManager authenticationManager;


    IJwtProvider jwtProvider;

    @Override
    public String signInAndReturnJWT(User signInRequest) //kimlik kontrolunu yapar
    {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signInRequest.getUsername(), signInRequest.getPassword())
        );

        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();

        return jwtProvider.generateToken(userPrincipal);
    }
}
