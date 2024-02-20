package net.runesoft.dndapi.controller;

import net.runesoft.dndapi.entities.UserEntity;
import net.runesoft.dndapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/get")
    public ResponseEntity<Optional<UserEntity>> getUser(@RequestParam String uid) {
        return ResponseEntity.ok(userService.get(uid));
    }

    @GetMapping("/find")
    public ResponseEntity<Optional<UserEntity>> findUser(@RequestParam String userName) {
        return ResponseEntity.ok(userService.findByName(userName));
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserEntity>> getAll() {
        return ResponseEntity.ok(userService.findAll());
    }

    @PostMapping("/create")
    public ResponseEntity<UserEntity> createUser(@RequestBody UserEntity newUser) {
        return ResponseEntity.ok(userService.save(newUser));
    }
}
