package net.runesoft.dndapi.repositories;

import net.runesoft.dndapi.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {

    public Optional<UserEntity> findByName(String name);
}
