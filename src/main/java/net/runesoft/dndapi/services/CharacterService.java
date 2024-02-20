package net.runesoft.dndapi.services;

import net.runesoft.dndapi.entities.CharacterEntity;
import net.runesoft.dndapi.entities.ClassEntity;
import net.runesoft.dndapi.entities.UserEntity;
import net.runesoft.dndapi.repositories.CharacterRepository;
import net.runesoft.dndapi.repositories.ClassRepository;
import net.runesoft.dndapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class CharacterService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CharacterRepository characterRepository;

    @Autowired
    private ClassRepository classRepository;

    public Optional<CharacterEntity> get(String uuid) {
        return characterRepository.findById(uuid);
    }

    public Optional<Set<CharacterEntity>> findByName(String name) {
        return characterRepository.findByName(name);
    }

    public Optional<CharacterEntity> findByName(String name, String userName) {
        Optional<UserEntity> userEntity = userRepository.findByName(userName);
        if (userEntity.isPresent()) {
            return characterRepository.findByNameAndUser(name, userEntity.get());
        }
        return Optional.empty();
    }

    public List<CharacterEntity> findAll() {
        return characterRepository.findAll();
    }

    /**
     * CREATE
     **/

    public CharacterEntity save(CharacterEntity newCharacter, String userName, String className) {
        Optional<UserEntity> userEntity = userRepository.findByName(userName);
        Optional<ClassEntity> classEntity = classRepository.findByName(className);
        if (userEntity.isPresent() && classEntity.isPresent()) {
            newCharacter.setUser(userEntity.get());
            if (newCharacter.getClasses() == null) newCharacter.setClasses(new HashSet<>());
            newCharacter.getClasses().add(classEntity.get());
            return characterRepository.save(newCharacter);
        }
        return new CharacterEntity();
    }

}
