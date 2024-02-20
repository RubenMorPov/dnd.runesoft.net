package net.runesoft.dndapi.services;

import net.runesoft.dndapi.entities.UserEntity;
import net.runesoft.dndapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Optional<UserEntity> get(String uid) {
        return userRepository.findById(uid);
    }

    public Optional<UserEntity> findByName(String name) {
        return userRepository.findByName(name);
    }

    public List<UserEntity> findAll() {
        return userRepository.findAll();
    }

    /**
     * CREATE
     **/

    public UserEntity save(UserEntity newUser) {
        return userRepository.save(newUser);
    }
}
