package com.erdem.dockerizedcrud.controller;


import com.erdem.dockerizedcrud.model.User;
import com.erdem.dockerizedcrud.service.IAuthenticationService;
import com.erdem.dockerizedcrud.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("api/authentication")//pre-path
public class AuthenticationController {

    private static Logger logger = Logger.getLogger((AuthenticationController.class).getName());
    @Autowired
    private IAuthenticationService authenticationService;

    @Autowired
    private IUserService userService;

    @PostMapping("sign-up") //api/authentication/sign-up
    public ResponseEntity<?> signUp(@RequestBody User user) {
        if (userService.findBUsername(user.getUsername()).isPresent()) {
            logger.log(Level.INFO, "Ayni kullanici kayitli, yeni token icin farkli username secin");
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        logger.log(Level.INFO, "Sign-up basarili");
        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
    }

    @PostMapping("sign-in")//api/authentication/sign-in
    public ResponseEntity<?> signIn(@RequestBody User user) {
        logger.log(Level.INFO, "Sign-in basarili");
        return new ResponseEntity<>(authenticationService.signInAndReturnJWT(user), HttpStatus.OK);
    }
}
