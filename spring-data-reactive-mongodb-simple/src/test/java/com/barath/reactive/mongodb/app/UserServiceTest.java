package com.barath.reactive.mongodb.app;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

/**
 * Created by barath on 31/03/18.
 */
public class UserServiceTest extends AbstractSpringRunner {

    @Autowired
    private  UserService userService;

    @Autowired
    private  UserRepository userRepository;



    @Test
    public void testMonoUser(){

        User user = new User("barath");
        Mono<User> barathMono = Mono.just(user);


        StepVerifier.create(barathMono).expectNext(user).verifyComplete();

    }

    @Test
    public void testAddUser(){

        User user = new User("test");
        Mono<User> testMono = Mono.just(user);
        System.out.println(userService);

        StepVerifier.create(this.userService.addUser(testMono)).expectNext(user).verifyComplete();

    }
}
