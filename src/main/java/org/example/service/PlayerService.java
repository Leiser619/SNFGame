package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.dto.HeroRequest;
import org.example.dto.ReturnedHero;
import org.example.model.*;
import org.example.repository.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PlayerService {
    private final HeroRepo heroRepo;
    private final HeroBackpackRepo heroBackpackRepo;
    private final ItemRepo itemRepo;
    private final BackpackItemRepo backpackItemRepo;


    public ReturnedHero showSelfF(HeroRequest heroRequest) {
        ReturnedHero returnedHero=new ReturnedHero();

        //getting your hero
        String name= heroRequest.getName();
        String professy= String.valueOf(heroRequest.getHeroClass());
        Hero hero=heroRepo.findByNameAndHeroClass(name,professy);

        //gettring your items
        Optional<HeroBackpack> heroBackpack=heroBackpackRepo.findByHeroId(hero.getId());
        List<Optional<Item>> items=new ArrayList<>();

        List<BackpackItem> backpackItem=backpackItemRepo.findByBackpackId(heroBackpack.get().getBackpackId());
        for (BackpackItem item : backpackItem) {
            Optional<Item> item1=itemRepo.findById(item.getId());
            items.add(item1);
        }


        returnedHero.setBackpack(items);
        returnedHero.setHero(hero);
        return returnedHero;
    }
}
