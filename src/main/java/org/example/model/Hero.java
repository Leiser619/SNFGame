package org.example.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "hero")
@Data
public class Hero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Enumerated(EnumType.STRING)
    private HeroClass heroClass;
    @NotEmpty
    private String name;
    private String avatar;
    private String weapon;
    private String spell;
    private int attack;
    private int magic;
    private int health;
    private int attackSpeed;
    private int backpackSpace;
    private int armor;
    private int level;
    private int gold;
}
