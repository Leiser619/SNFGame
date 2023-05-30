package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.model.Monster;
import org.example.model.Orygin;
import org.example.service.MonsterService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.lang.model.util.Elements;
import java.util.List;

@PreAuthorize("hasRole('PLAYER')")
@RestController
@RequestMapping("/game")
@RequiredArgsConstructor
public class MonsterController {
    private final MonsterService monsterService;
    @GetMapping("/{orygin}")
    public List<Monster> forest(@PathVariable Orygin orygin){
        return monsterService.forest(orygin);}
    @GetMapping("/{origin}/{name}")
    public Monster templeFight(@PathVariable String origin, @PathVariable String name){return monsterService.templeFight(origin,name);}



}
