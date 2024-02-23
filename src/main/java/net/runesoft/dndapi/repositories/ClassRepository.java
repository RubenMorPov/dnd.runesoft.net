package net.runesoft.dndapi.repositories;

import net.runesoft.dndapi.entities.CClassEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClassRepository extends JpaRepository<CClassEntity, String> {

    Optional<CClassEntity> findByName(String name);
}
