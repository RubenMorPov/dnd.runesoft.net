package net.runesoft.dndapi.controller;

import net.runesoft.dndapi.entities.CharacterEntity;
import net.runesoft.dndapi.services.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/character")
public class CharacterController {

    @Autowired
    private CharacterService characterService;

    @GetMapping("/get")
    public ResponseEntity<Optional<CharacterEntity>> getCharacter(@RequestParam String uid) {
        return ResponseEntity.ok(characterService.get(uid));
    }

    @GetMapping("/find")
    public ResponseEntity<Optional<Set<CharacterEntity>>> findCharacter(@RequestParam String name) {
        return ResponseEntity.ok(characterService.findByName(name));
    }

    @GetMapping("/find-by-user")
    public ResponseEntity<Optional<CharacterEntity>> findCharacter(@RequestParam String name,
                                                                   @RequestParam String userName) {
        return ResponseEntity.ok(characterService.findByName(name, userName));
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
