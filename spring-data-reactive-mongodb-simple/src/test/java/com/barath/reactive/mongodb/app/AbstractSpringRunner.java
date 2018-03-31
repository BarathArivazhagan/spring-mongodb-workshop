package com.barath.reactive.mongodb.app;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

/**
 * Created by barath on 31/03/18.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ReactiveMongoApplication.class,UserService.class})
public abstract class AbstractSpringRunner {

   
}
