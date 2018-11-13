package ua.demo.controller;

import feign.Feign;
import feign.Logger;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import org.springframework.cloud.openfeign.support.SpringMvcContract;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.demo.feign.UserClient;
import ua.demo.model.User;

import java.util.List;

@RestController
public class UserController {
    @GetMapping(value = "/read")
    public String read() {
        UserClient userClient = Feign.builder()
                .contract(new SpringMvcContract())
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .logger(new Logger.ErrorLogger())
                .logLevel(Logger.Level.FULL)
                .target(UserClient.class, "https://jsonplaceholder.typicode.com");

        List<User> users = userClient.getUsers();

        return String.format("Retrieved %d users total", users.size());
    }
}
