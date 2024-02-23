package net.runesoft.dndapi.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "classes")
@Data
@NoArgsConstructor
public class CClassEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "CLASS_UID", nullable = false)
    private String uid;
    @Column(name = "CLASS_NAME", nullable = false, unique = true)
    private String name;
    @Column(name = "CLASS_DESCRIPTION", nullable = false)
    private String description;

    @OneToMany(mappedBy = "cclass")
    @JsonIgnore
    private List<CharactersClassesEntity> characterClasses = new ArrayList<>();
}
