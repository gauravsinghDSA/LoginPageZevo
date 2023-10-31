package com.example.LoginPageZevo.Services;
import com.example.LoginPageZevo.Models.Login;
import com.example.LoginPageZevo.Repository.LoginRepositoryMongo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class LoginServices {
    @Autowired
    @Qualifier("loginRepository")
    private LoginRepositoryMongo loginRepository;
    @Autowired
    public LoginServices(LoginRepositoryMongo loginRepository) {
        this.loginRepository = loginRepository;
    }


    public Login CheckLogin(String loginID, String password) {
        if (loginID == null || password == null) {
            // Handle invalid input, e.g., return null or throw an exception
            return null;
        }

        // Query the database to find a login record with the provided loginID
        Login login = loginRepository.findByLoginID(loginID);

        if (login != null && login.getPassword().equals(password)) {
            // Passwords match, return the login record
            return login;
        } else {
            // Login record not found or password doesn't match
            return null;
        }
    }
}

