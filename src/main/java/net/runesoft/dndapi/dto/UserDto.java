package net.runesoft.dndapi.dto;

import lombok.Builder;
import lombok.Data;

import java.util.HashMap;
import java.util.List;

@Builder
@Data
public class UserDto {

    private String uuid;
    private String name;
    private String mail;

    private HashMap<String, CharacterDto> characters;
}
