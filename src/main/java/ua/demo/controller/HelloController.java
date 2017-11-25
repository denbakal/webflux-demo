package ua.demo.controller;

import org.reactivestreams.Publisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class HelloController {
    @GetMapping("/")
    public Publisher<String> handler() {
        return Mono.just("Hello World!!!");
    }
}
