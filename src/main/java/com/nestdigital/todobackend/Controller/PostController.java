package com.nestdigital.todobackend.Controller;

import com.nestdigital.todobackend.Dao.PostDao;
import com.nestdigital.todobackend.Model.PostModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

@RestController
public class PostController {

    @Autowired
    private PostDao dao;

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/addpost",consumes = "application/json",produces = "application/json")
    public String Addpost(@RequestBody PostModel post){
        DateTimeFormatter dt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String currentdate = String.valueOf(dt.format(now));
        post.setPosted_date(currentdate);
        System.out.println(post.toString());
        dao.save(post);
        return "{Status:'Success}";
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/viewSingle",consumes = "application/json",produces = "application/json")
    public List<Map<String,String>> ViewSingle(@RequestBody PostModel post)
    {
        return (List<Map<String, String>>) dao.ViewAllSingle(post.getUser_id());
    }

}
