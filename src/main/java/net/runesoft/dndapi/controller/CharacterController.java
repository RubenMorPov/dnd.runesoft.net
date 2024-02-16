package net.runesoft.dndapi.controller;

import net.runesoft.dndapi.entities.CharacterEntity;
import net.runesoft.dndapi.repositories.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/character")
public class CharacterController {

    @Autowired
    private CharacterRepository characterRepository;

    @GetMapping("/get")
    public ResponseEntity<Optional<CharacterEntity>> getCharacter(@RequestParam String userName, @RequestParam String name) {
        return ResponseEntity.ok(characterRepository.findByName(name));
    }

    @PostMapping("/create")
    public ResponseEntity<CharacterEntity> createCharacter(@RequestParam String userName, @RequestBody CharacterEntity newCharacter) {
        return ResponseEntity.ok(characterRepository.save(newCharacter));
    }

    @GetMapping("/all")
    public ResponseEntity<List<CharacterEntity>> getAll(@RequestParam String userName) {
        return ResponseEntity.ok(characterRepository.findAll());
    }
}
