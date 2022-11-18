package com.erdem.dockerizedcrud.security.jwt;



import com.erdem.dockerizedcrud.security.UserPrincipal;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;


public interface IJwtProvider {
    String generateToken(UserPrincipal authentication);

    Authentication getAuthentication(HttpServletRequest request);

    boolean isTokenValid(HttpServletRequest request);
}
