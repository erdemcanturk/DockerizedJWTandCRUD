package com.erdem.dockerizedcrud.service;

import com.erdem.dockerizedcrud.model.JwtRefreshToken;
import com.erdem.dockerizedcrud.model.User;


public interface JwtRefreshTokenService
{
    JwtRefreshToken createRefreshToken(Long userId);

    User generateAccessTokenFromRefreshToken(String refreshTokenId);
}
