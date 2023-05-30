package org.example.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.example.model.Orygin;
@Data
public class MonsterRequest {
    private String name;
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
