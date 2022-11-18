package com.erdem.dockerizedcrud.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
@EnableWebSecurity
public class SecurityConfig  {

    @Autowired
     CustomUserDetailsService customUserDetailsService;


    protected void configure(AuthenticationManagerBuilder auth) throws Exception
    {
        auth
                .userDetailsService(customUserDetailsService) //kullanicilarin nasil alacagini burda belirledik
                .passwordEncoder(passwordEncoder());
    }


    @Bean(BeanIds.AUTHENTICATION_MANAGER)
    public AuthenticationManager authenticationManagerBean(HttpSecurity http, UserDetailsService userDetailService ) throws Exception
    {
        return http.getSharedObject(AuthenticationManagerBuilder.class)
                .userDetailsService(userDetailService).and().build();    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception
    {
        http.csrf().disable(); //sessiona bagli olarak kullanilan ataklari engellemek icin. biz session degil JWT tokeni kullanacagiz
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.authorizeRequests()
                .antMatchers(HttpMethod.OPTIONS).permitAll()
                .antMatchers("/api/authentication/**").permitAll()//sign up sign in pre-path
                .anyRequest().authenticated();

        http.addFilterBefore(jwtAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }


    public PasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }


    public JwtAuthorizationFilter jwtAuthorizationFilter()
    {
        return new JwtAuthorizationFilter();
    }

    //Cross origin resource sharing.
    @Bean
    public WebMvcConfigurer corsConfigurer()
    {
        return new WebMvcConfigurer()
        {
            @Override
            public void addCorsMappings(CorsRegistry registry)
            {
                registry.addMapping("/**")
                        .allowedOrigins("*") //localhost, "^http://([-\\w]*.)?localhost(:[0-9]*)?"
                        .allowedMethods("*"); //POST, GET, ...
            }
        };
    }
}
