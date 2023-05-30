package org.example.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.example.dto.HeroRequest;
import org.example.dto.ReturnedHero;
import org.example.model.Hero;
import org.example.model.Monster;
import org.example.model.Orygin;
import org.example.service.MapService;
import org.example.service.PlayerService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@PreAuthorize("hasRole('PLAYER')")
@RestController
@RequestMapping("/game")
@RequiredArgsConstructor
public class MapController {
    private final MapService mapService;
    private final PlayerService playerService;
    @GetMapping("/map")
    public String showMap(){
        return "MAPA";
    }
    @GetMapping("/player")
    public ReturnedHero playerr(@RequestBody HeroRequest heroRequest){
        return playerService.showSelfF(heroRequest);
    }
}
