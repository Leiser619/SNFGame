package org.example.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ItemRequest {
    private int attack;
    private int magic;
    private int health;
    private int attack_speed;
    private int armor;
    private String avatar;
    private int cost;
}
