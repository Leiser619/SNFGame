package org.example.dto;

import lombok.Data;
import org.example.model.Hero;
import org.example.model.Item;

import java.util.List;
import java.util.Optional;

@Data
public class ReturnedHero {
    List<Optional<Item>> backpack;
    Hero hero;
}
