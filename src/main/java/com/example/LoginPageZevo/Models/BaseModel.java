package com.example.LoginPageZevo.Models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
public class BaseModel {
    @Id
    private Long id;
}
