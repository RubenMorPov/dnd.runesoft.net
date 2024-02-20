package net.runesoft.dndapi.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table(name = "classes")
@Data
@NoArgsConstructor
public class ClassEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "CLASS_UID", nullable = false)
    private String uid;
    @Column(name = "CLASS_NAME", nullable = false, unique = true)
    private String name;
    @Column(name = "CLASS_DESCRIPTION", nullable = false)
    private String description;

    @ManyToMany(mappedBy = "classes")
    Set<CharacterEntity> characters;
}
