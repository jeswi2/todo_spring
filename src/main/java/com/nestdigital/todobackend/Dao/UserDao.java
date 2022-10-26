package com.nestdigital.todobackend.Dao;

import com.nestdigital.todobackend.Model.UserModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

public interface UserDao extends CrudRepository<UserModel,Integer> {
    @Query(value = "SELECT `id`, `dob`, `email`, `name`, `password`, `phone`, `place` FROM `users` WHERE `email`= :email AND `password`= :password",nativeQuery = true)
    List<UserModel> Signup(String email, String password);
}
