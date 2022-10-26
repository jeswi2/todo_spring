package com.nestdigital.todobackend.Dao;

import com.nestdigital.todobackend.Model.PostModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Map;

public interface PostDao extends CrudRepository<PostModel,Integer> {
    @Query(value = "SELECT * FROM `posts` WHERE `user_id`= :user_id",nativeQuery = true)
    List<Map<String,String>> ViewAllSingle(Integer user_id);
}
