package com.example.demo.config;



import com.example.demo.entities.Comment;
import com.example.demo.entities.Post;
import com.example.demo.entities.User;
import com.example.demo.repository.CommentRepository;
import com.example.demo.repository.PostRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;



import org.slf4j.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Optional;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(UserRepository userRepository, CommentRepository commentRepository,PostRepository postRepository) {

        return args -> {
            User user = new User("ahmet","123");
            User user2 = new User("ahmet","123");
            User user3 = new User("ahmet","123");
            userRepository.save(user3);
            userRepository.save(user2);
            userRepository.save(user);
            Post post1 = new Post("fasdf", user,"2fsfsdafsadf");
            Post post2 = new Post("fasdf", user,"2fsfsdafsadf");
            Post post3 = new Post("fasdf", user,"2fsfsdafsadf");
            Post post4 = new Post("fasdf", user2,"2fsfsdafsadf");
            Post post5 = new Post("fasdf", user2,"2fsfsdafsadf");
            Post post6 = new Post("fasdf", user2,"2fsfsdafsadf");
            postRepository.save(post1);
            postRepository.save(post2);
            postRepository.save(post3);
            postRepository.save(post4);
            postRepository.save(post5);
            postRepository.save(post6);
            Comment comment1 = new Comment(user,post1,"fdsafdsaffsdfasdf");
            Comment comment2 = new Comment(user,post1,"fdsafdsaffsdfasdf");
            Comment comment3 = new Comment(user2,post1,"fdsafdsaffsdfasdf");
            Comment comment4 = new Comment(user3,post2,"fdsafdsaffsdfasdf");
            Comment comment5 = new Comment(user,post2,"fdsafdsaffsdfasdf");
            Comment comment6 = new Comment(user3,post2,"fdsafdsaffsdfasdf");
            commentRepository.save(comment1);
            commentRepository.save(comment2);
            commentRepository.save(comment3);
            commentRepository.save(comment4);
            commentRepository.save(comment5);
            commentRepository.save(comment6);
        };
    }
}