package com.in28minutes.springboot.web.springbootfirstwebapplication;

import org.springframework.stereotype.Component;

@Component
public class LoginService {
    public boolean validateUser(String user, String password) {
        return user.equalsIgnoreCase("mahmoud") && password.equals("mahmoudpassword");
    }
}
