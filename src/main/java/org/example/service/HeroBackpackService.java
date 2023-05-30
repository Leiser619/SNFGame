package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.model.HeroBackpack;
import org.example.repository.HeroBackpackRepo;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HeroBackpackService {
    private final HeroBackpackRepo heroBackpackRepo;
    public void add(Long backpackId, Long heroId) {
        HeroBackpack heroBackpack=new HeroBackpack();
        heroBackpack.setHeroId(heroId);
        heroBackpack.setBackpackId(backpackId);
        heroBackpackRepo.save(heroBackpack);
        System.out.println("dodano plecak do bohatera");
    }
}
