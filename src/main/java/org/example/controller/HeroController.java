package org.example.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.example.dto.HeroRequest;
import org.example.model.Hero;
import org.example.repository.HeroRepo;
import org.example.service.HeroService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@PreAuthorize("hasRole('PLAYER')")
@RestController
@RequestMapping("/hero")
@RequiredArgsConstructor
public class HeroController {
    private final HeroService heroService;

    @PostMapping("/create")
    public Hero createHero(@RequestBody HeroRequest heroRequest,
                           HttpServletRequest request,
                           HttpServletResponse response) throws Exception {
        return heroService.save(heroRequest,request,response);
    }
}
