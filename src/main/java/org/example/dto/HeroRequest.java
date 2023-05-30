package org.example.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
import org.example.model.HeroClass;
@Data
public class HeroRequest {
    private HeroClass heroClass;
    private String name;
}
