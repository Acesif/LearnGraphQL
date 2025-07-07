package com.acesif.graphQL.controller;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Mono;

@Controller
public class Demo {

    @QueryMapping
    public Mono<String> sayHello(){
        return Mono.fromSupplier(() -> "Yello");
    }

    @QueryMapping
    public Mono<String> sayHelloTo(@Argument String name){
        return Mono.fromSupplier(() -> "Yello "+name);
    }
}
