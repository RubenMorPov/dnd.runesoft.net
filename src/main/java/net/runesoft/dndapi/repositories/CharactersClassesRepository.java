package net.runesoft.dndapi.repositories;

import net.runesoft.dndapi.entities.CharactersClassesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharactersClassesRepository extends JpaRepository<CharactersClassesEntity, String> {

}
