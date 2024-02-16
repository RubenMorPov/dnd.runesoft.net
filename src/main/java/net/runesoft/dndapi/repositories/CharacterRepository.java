package net.runesoft.dndapi.repositories;

import net.runesoft.dndapi.entities.CharacterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CharacterRepository extends JpaRepository<CharacterEntity, String> {

    public Optional<CharacterEntity> findByName(String name);
}
