package net.runesoft.dndapi.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "characters")
@Data
@NoArgsConstructor
public class CharacterEntity {
    // CAMPOS
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "CHARACTER_UID", nullable = false)
    private String uid;
    @Column(name = "CHARACTER_NAME", nullable = false)
    private String name;
    @Column(name = "CHARACTER_STRENGTH", nullable = false)
    private int strength;
    @Column(name = "CHARACTER_DEXTERITY", nullable = false)
    private int dexterity;
    @Column(name = "CHARACTER_CONSTITUTION", nullable = false)
    private int constitution;
    @Column(name = "CHARACTER_INTELLIGENCE", nullable = false)
    private int intelligence;
    @Column(name = "CHARACTER_WISDOM", nullable = false)
    private int wisdom;
    @Column(name = "CHARACTER_CHARISMA", nullable = false)
    private int charisma;

    @ManyToOne
    @JoinColumn(name = "USER_UID", nullable = false)
    private UserEntity user;
}
