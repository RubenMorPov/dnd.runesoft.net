package net.runesoft.dndapi.repositories;

import net.runesoft.dndapi.entities.CharacterEntity;
import net.runesoft.dndapi.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Repository
public interface CharacterRepository extends JpaRepository<CharacterEntity, String> {

    Optional<List<CharacterEntity>> findByName(String name);

    Optional<CharacterEntity> findByNameAndUser(String name, UserEntity user);

    Optional<List<CharacterEntity>> findByUser(UserEntity user);

    @Query("select c from CharacterEntity c where name = :name")
    Optional<CharacterEntity> getCharacterData(@Param("name") String characterName);
}
