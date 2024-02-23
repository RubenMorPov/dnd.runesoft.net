package net.runesoft.dndapi.controller;

import net.runesoft.dndapi.entities.CharacterEntity;
import net.runesoft.dndapi.services.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/character")
public class CharacterController {

    @Autowired
    private CharacterService characterService;

    @GetMapping("/get")
    public ResponseEntity<Optional<CharacterEntity>> getCharacter(@RequestParam String uid) {
        return ResponseEntity.ok(characterService.get(uid));
    }

    @GetMapping("/find/by-name")
    public ResponseEntity<Optional<List<CharacterEntity>>> findCharacterByName(@RequestParam String name) {
        return ResponseEntity.ok(characterService.findByNameAndUser(name));
    }

    @GetMapping("/find-by-user")
    public ResponseEntity<Optional<List<CharacterEntity>>> findCharacterByUser(@RequestParam String userName) {
        return ResponseEntity.ok(characterService.findByUser(userName));
    }

        @GetMapping("/find/by-name-and-user")
    public ResponseEntity<Optional<CharacterEntity>> findCharacterByNameAndUser(@RequestParam String name,
                                                                   @RequestParam String userName) {
        return ResponseEntity.ok(characterService.findByNameAndUser(name, userName));
    }

    @PostMapping("/create")
    public ResponseEntity<CharacterEntity> createCharacter(@RequestBody CharacterEntity newCharacter,
                                                           @RequestParam String userName,
                                                           @RequestParam String className) {
        return ResponseEntity.ok(characterService.save(newCharacter, userName, className));
    }

    @GetMapping("/all")
    public ResponseEntity<List<CharacterEntity>> getAll(@RequestParam String userName) {
        return ResponseEntity.ok(characterService.findAll());
    }
}
