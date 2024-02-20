package net.runesoft.dndapi.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "USER_UID", nullable = false)
    private String uid;
    @Column(name = "USER_NAME", nullable = false, unique = true)
    private String name;
    @Column(name = "USER_MAIL", nullable = false)
    private String mail;
}
