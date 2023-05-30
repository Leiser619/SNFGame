package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.HeroBaseRequest;
import org.example.dto.ItemRequest;
import org.example.dto.MonsterRequest;
import org.example.model.HeroBase;
import org.example.model.Item;
import org.example.model.Monster;
import org.example.service.CreateService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@PreAuthorize("hasRole('ADMIN')")
@RestController
@RequestMapping("/create")
@RequiredArgsConstructor
public class AdminController {
    private final CreateService createService;
    @PostMapping("/monster")
    public Monster createMonster(@RequestBody MonsterRequest monsterRequest){
        return createService.createMonster(monsterRequest);
    }
    @PostMapping("/herobase")
    public HeroBase createHeroBase(@RequestBody HeroBaseRequest heroBaseRequest){
        return createService.createHeroBase(heroBaseRequest);
    }
    @PostMapping("/item")
    public Item createitem(@RequestBody ItemRequest itemRequest){
        return createService.createItem(itemRequest);
    }

}
