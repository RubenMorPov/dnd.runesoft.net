package net.runesoft.dndapi.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "characters_classes")
@Data
@NoArgsConstructor
public class CharactersClassesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "CHARACTER_CLASS_UID", nullable = false)
    private String characterClassUid;

    @ManyToOne
    @JoinColumn(name = "CHARACTER_UID")
    @JsonIgnore
    private CharacterEntity character;

    @ManyToOne
    @JoinColumn(name = "CLASS_UID")
    private CClassEntity cclass;

    @Column(name = "CHARACTER_CLASS_LEVEL", nullable = false)
    private int level;
}
