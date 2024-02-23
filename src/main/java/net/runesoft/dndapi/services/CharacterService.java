package net.runesoft.dndapi.services;

import net.runesoft.dndapi.entities.CClassEntity;
import net.runesoft.dndapi.entities.CharacterEntity;
import net.runesoft.dndapi.entities.CharactersClassesEntity;
import net.runesoft.dndapi.entities.UserEntity;
import net.runesoft.dndapi.repositories.CharacterRepository;
import net.runesoft.dndapi.repositories.CharactersClassesRepository;
import net.runesoft.dndapi.repositories.ClassRepository;
import net.runesoft.dndapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CharacterService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CharacterRepository characterRepository;

    @Autowired
    private ClassRepository classRepository;

    @Autowired
    private CharactersClassesRepository charactersClassesRepository;

    public Optional<CharacterEntity> get(String uuid) {
        return characterRepository.findById(uuid);
    }

    public Optional<List<CharacterEntity>> findByNameAndUser(String name) {
        return characterRepository.findByName(name);
    }

    public Optional<CharacterEntity> findByNameAndUser(String name, String userName) {
        Optional<UserEntity> userEntity = userRepository.findByName(userName);
        if (userEntity.isPresent()) {
            return characterRepository.findByNameAndUser(name, userEntity.get());
        }
        return Optional.empty();
    }

    public Optional<List<CharacterEntity>> findByUser(String userName) {
        Optional<UserEntity> userEntity = userRepository.findByName(userName);
        if (userEntity.isPresent()) {
            return characterRepository.findByUser(userEntity.get());
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
        Optional<CClassEntity> classEntity = classRepository.findByName(className);
        if (userEntity.isPresent() && classEntity.isPresent()) {
            newCharacter.setUser(userEntity.get());
            CharacterEntity savedCharacter = characterRepository.save(newCharacter);
            getNewCharacterClass(newCharacter, classEntity.get());
            return savedCharacter;
        }
        return new CharacterEntity();
    }

    public CharactersClassesEntity getNewCharacterClass(CharacterEntity character, CClassEntity classEntity) {
        CharactersClassesEntity charactersClasses = new CharactersClassesEntity();

        charactersClasses.setCharacter(character);
        charactersClasses.setCclass(classEntity);
        charactersClasses.setLevel(1);

        return charactersClassesRepository.save(charactersClasses);
    }

}
