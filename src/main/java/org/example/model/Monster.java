package org.example.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;


@Entity
@Table(name = "monster")
@Data
public class Monster {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @Enumerated(EnumType.STRING)
    private Orygin orygin;
    private int atack;
    private int health;
    private int magic;
    private int luck;
    private int attackSpeed;
    private int armor;
    private String weapon;
    private String spell;
    private String avatar;
    private int baseEXP;
    private int baseGold;
}
