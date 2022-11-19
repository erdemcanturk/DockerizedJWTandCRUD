package com.erdem.dockerizedcrud.repository;

import com.erdem.dockerizedcrud.model.JwtRefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JwtRefreshTokenRepository extends JpaRepository<JwtRefreshToken, String>
{
}
