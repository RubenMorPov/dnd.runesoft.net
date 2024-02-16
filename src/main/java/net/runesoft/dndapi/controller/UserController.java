package net.runesoft.dndapi.controller;

import net.runesoft.dndapi.entities.UserEntity;
import net.runesoft.dndapi.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UsersRepository usersRepository;

    @GetMapping("/get")
    public ResponseEntity<Optional<UserEntity>> getUser(@RequestParam String userName) {
        return ResponseEntity.ok(usersRepository.findByName(userName));
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserEntity>> getAll() {
        return ResponseEntity.ok(usersRepository.findAll());
    }

    @PostMapping("/create")
    public ResponseEntity<UserEntity> createUser(@RequestBody UserEntity newUser) {
        return ResponseEntity.ok(usersRepository.save(newUser));
    }
}
