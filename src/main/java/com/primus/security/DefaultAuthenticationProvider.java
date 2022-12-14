package com.primus.security;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class DefaultAuthenticationProvider implements AuthenticationProvider {

   // @Autowired
  //  UserService userService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String name = authentication.getName();
        String password = authentication.getCredentials().toString();
     /*  User loggedInUser = userService.getLogin(name,password);
        if (loggedInUser != null)
            return new UsernamePasswordAuthenticationToken(
                name, password, new ArrayList<>());
        else*/
            return  null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
