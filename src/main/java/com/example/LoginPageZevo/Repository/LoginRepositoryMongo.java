package com.example.LoginPageZevo.Repository;

import com.example.LoginPageZevo.Models.Login;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository("loginRepositoryMongo")
public interface LoginRepositoryMongo extends MongoRepository<Login, String> {
    Login findByLoginID(String loginID);
}
