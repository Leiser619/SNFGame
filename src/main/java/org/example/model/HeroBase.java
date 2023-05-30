package org.example.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NonNull;

@Entity
@Table(name = "herobase")
@Data
public class HeroBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Enumerated(EnumType.STRING)
    private HeroClass heroClass;
    private String avatar;
    private String weapon;
    private String spell;
    private int attack;
    private int magic;
    private int health;
    private int attackSpeed;
    private int armor;
    private int backpackSpace;

}
