package net.runesoft.dndapi.repositories;

import net.runesoft.dndapi.entities.CharacterEntity;
import net.runesoft.dndapi.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface CharacterRepository extends JpaRepository<CharacterEntity, String> {

    Optional<Set<CharacterEntity>> findByName(String name);

    Optional<CharacterEntity> findByNameAndUser(String name, UserEntity user);
}
