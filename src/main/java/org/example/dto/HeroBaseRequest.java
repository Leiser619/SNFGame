package org.example.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class HeroBaseRequest {
    private String heroClass;
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
