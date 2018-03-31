package com.barath.reactive.mongodb.app;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Created by barath on 31/03/18.
 */
public interface UserRepository extends ReactiveMongoRepository<User,String> {

    Flux<User> findByUserName(Mono<String> userName);

}