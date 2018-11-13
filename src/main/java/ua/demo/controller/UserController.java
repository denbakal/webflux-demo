package ua.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ua.demo.feign.UserClient;
import ua.demo.model.User;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserClient userClient;

    @RequestMapping("/create")
    @ResponseBody
    String create() {
        User user = userClient.getUser(1L);
        user.setId(null);
        user = userClient.createUser(user);

        return String.format("Created a user with id %d", user.getId());
    }

    @RequestMapping("/read")
    @ResponseBody
    String read() {
        List<User> users = userClient.getUsers();

        return String.format("Retrieved %d users total", users.size());
    }

    @RequestMapping("/update")
    @ResponseBody
    String update() {
        User user = userClient.getUser(1L);
        String oldName = user.getName();
        user.setName("John");
        userClient.updateUser(1L, user);

        return String.format("Update successful. User id: %d, old name: %s, new name: %s",
                user.getId(), oldName, user.getName());
    }

    @RequestMapping("/delete")
    @ResponseBody
    String delete() {
        userClient.deleteUser(1L);

        return "Deleted";
    }

}
