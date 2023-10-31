package com.example.LoginPageZevo.Controller;

import com.example.LoginPageZevo.DTO.LoginRequestDTO;
import com.example.LoginPageZevo.DTO.LoginResponseDTO;
import com.example.LoginPageZevo.Exception.LoginException;
import com.example.LoginPageZevo.Models.Login;
import com.example.LoginPageZevo.Services.LoginServices;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    private LoginServices loginServices;

    public LoginController(LoginServices loginServices){
        this.loginServices = loginServices;
    }

    @PostMapping("/login")
    public LoginResponseDTO LoginCheck(@RequestBody LoginRequestDTO loginRequestDTO) throws LoginException {
        LoginResponseDTO loginResponseDTO = new LoginResponseDTO();
        try {
            Login login = loginServices.CheckLogin(loginRequestDTO.getLoginID(), loginRequestDTO.getPassword());
            if (login!=null) {
                loginResponseDTO.setStatus("logged in Succesfully");
            }
            else {
                throw new LoginException();
            }

        } catch (Exception ex) {
            loginResponseDTO.setStatus("Not able to login");
        }
        return loginResponseDTO;
    }
}

