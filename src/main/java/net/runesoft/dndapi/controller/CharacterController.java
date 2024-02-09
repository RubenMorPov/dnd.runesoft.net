package net.runesoft.dndapi.controller;

import net.runesoft.dndapi.dto.CharacterDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/character")
public class CharacterController {

    @GetMapping("/get")
    public ResponseEntity<CharacterDto> getCharacter(@RequestParam String userName, @RequestParam String name) {
        CharacterDto character = UserController.users.get(userName).getCharacters().get(name);
        return ResponseEntity.ok(character);
    }

    @PostMapping("/create")
    public void createCharacter(@RequestParam String userName, @RequestBody CharacterDto newCharacter) {
        UserController.users.get(userName).getCharacters().put(newCharacter.getName(), newCharacter);
    }

    @GetMapping("/all")
    public ResponseEntity<HashMap<String, CharacterDto>> getAll(@RequestParam String userName) {
        return ResponseEntity.ok(UserController.users.get(userName).getCharacters());
    }
}
