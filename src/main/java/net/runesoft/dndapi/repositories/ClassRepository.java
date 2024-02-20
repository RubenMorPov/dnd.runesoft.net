package net.runesoft.dndapi.repositories;

import net.runesoft.dndapi.entities.ClassEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClassRepository extends JpaRepository<ClassEntity, String> {

    Optional<ClassEntity> findByName(String name);
}
