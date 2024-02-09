package net.runesoft.dndapi.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CharacterDto {

    private String name;
    // STATS
    private int strength;
    private int dexterity;
    private int constitution;
    private int intelligence;
    private int wisdom;
    private int charisma;
}
