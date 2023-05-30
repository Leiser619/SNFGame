package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.dto.HeroBaseRequest;
import org.example.dto.ItemRequest;
import org.example.dto.MonsterRequest;
import org.example.model.HeroBase;
import org.example.model.HeroClass;
import org.example.model.Item;
import org.example.model.Monster;
import org.example.repository.HeroBaseRepo;
import org.example.repository.ItemRepo;
import org.example.repository.MonsterRepo;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateService {
    private final MonsterRepo monsterRepo;
    private final HeroBaseRepo heroBaseRepo;
    private final ItemRepo itemRepo;
    public Monster createMonster(MonsterRequest monsterRequest) {
        Monster monster =new Monster();
        monster.getId();
        monster.setName(monsterRequest.getName());
        monster.setOrygin(monsterRequest.getOrygin());
        monster.setAtack(monsterRequest.getAtack());
        monster.setHealth(monsterRequest.getHealth());
        monster.setMagic(monsterRequest.getMagic());
        monster.setLuck(monsterRequest.getLuck());
        monster.setAttackSpeed(monsterRequest.getAttackSpeed());
        monster.setArmor(monsterRequest.getArmor());
        monster.setWeapon(monsterRequest.getWeapon());
        monster.setSpell(monsterRequest.getSpell());
        monster.setAvatar(monsterRequest.getAvatar());
        monster.setBaseEXP(monsterRequest.getBaseEXP());
        monster.setBaseGold(monsterRequest.getBaseGold());
        return monsterRepo.save(monster);
    }

    public HeroBase createHeroBase(HeroBaseRequest heroBaseRequest) {

        HeroBase heroBase=new HeroBase();
        heroBase.getId();
        heroBase.setArmor(heroBaseRequest.getArmor());
        heroBase.setHeroClass(HeroClass.valueOf(heroBaseRequest.getHeroClass()));
        heroBase.setAttack(heroBaseRequest.getAttack());
        heroBase.setBackpackSpace(heroBaseRequest.getBackpackSpace());
        heroBase.setAvatar(heroBaseRequest.getAvatar());
        heroBase.setHealth(heroBaseRequest.getHealth());
        heroBase.setMagic(heroBaseRequest.getMagic());
        heroBase.setSpell(heroBaseRequest.getSpell());
        heroBase.setWeapon(heroBaseRequest.getWeapon());
        heroBase.setAttackSpeed(heroBaseRequest.getAttackSpeed());
    return heroBaseRepo.save(heroBase);
    }

    public Item createItem(ItemRequest itemRequest) {
        Item item=new Item();
        item.getId();
        item.setAttack_speed(itemRequest.getAttack_speed());
        item.setArmor(itemRequest.getArmor());
        item.setHealth(itemRequest.getHealth());
        item.setAttack(itemRequest.getAttack());
        item.setMagic(itemRequest.getMagic());
        item.setCost(itemRequest.getCost());
        item.setAvatar(itemRequest.getAvatar());
        return itemRepo.save(item);
    }
}
