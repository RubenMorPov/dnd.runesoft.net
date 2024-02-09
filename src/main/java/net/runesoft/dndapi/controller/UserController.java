package net.runesoft.dndapi.controller;

import net.runesoft.dndapi.dto.UserDto;
import org.apache.catalina.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

import java.util.HashMap;

@RestController
@RequestMapping("/user")
public class UserController {

    public static HashMap<String, UserDto> users = new HashMap<>();

    @GetMapping("/get")
    public ResponseEntity<UserDto> getUser(@RequestParam String userName) {
        UserDto user = users.get(userName);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/create")
    public void createUser(@RequestBody UserDto newUser) {
        newUser.setCharacters(new HashMap<>());
        users.put(newUser.getName(), newUser);
    }
}
