package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.model.Backpack;
import org.example.model.Hero;
import org.example.model.HeroBackpack;
import org.example.repository.BackpackRepo;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BackpackService {
    private final BackpackRepo backpackRepo;
    private final HeroBackpackService heroBackpackService;
    public void create(Hero hero) {
        Backpack backpack=new Backpack();
        backpack.getId();
        backpack.setMaxSpace(hero.getBackpackSpace());
        backpack.setCurrentSpace(hero.getBackpackSpace());
        backpackRepo.save(backpack);
        heroBackpackService.add(backpack.getId(), (long) hero.getId());
    }
}
