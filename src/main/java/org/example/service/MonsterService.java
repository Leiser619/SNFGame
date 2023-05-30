package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.model.Monster;
import org.example.model.Orygin;
import org.example.repository.MonsterRepo;
import org.springframework.stereotype.Service;

import javax.lang.model.util.Elements;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MonsterService {
    private final MonsterRepo monsterRepo;

    public List<Monster> forest(Orygin orygin) {return monsterRepo.findByOrygin(orygin);}

    public List<Monster> dragon() {
        return monsterRepo.findByOrygin(Orygin.DRAGON);
    }

    public List<Monster> temple() {
        return monsterRepo.findByOrygin(Orygin.TEMPLE);
    }

    public Monster templeFight(String orygin, String name) {
        Monster monster= monsterRepo.findByNameOrygin(name,orygin.toUpperCase());
        return monster;
    }

}
