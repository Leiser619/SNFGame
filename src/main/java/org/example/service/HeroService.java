package org.example.service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.example.dto.HeroRequest;
import org.example.model.*;
import org.example.repository.*;
import org.example.security.JWTUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class HeroService {
    private final HeroBaseRepo heroBaseRepo;
    private final HeroRepo heroRepo;
    private final BackpackService backpackService;
    private final JWTUtils jwtUtils;
    private final UserRepository userRepository;
    private final UserHeroRepo userHeroRepo;
    public String getUserName(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response){
        final String authHeader = request.getHeader("Authorization");
        if (authHeader == null || !authHeader.startsWith("Bearer")) {
            return "Wrong token";
        }

        String jwt = authHeader.substring(7);
        String username = jwtUtils.extractUsername(jwt);
        return username;
    }
    public Hero save(HeroRequest heroRequest,HttpServletRequest request, HttpServletResponse response) throws Exception {
        Integer a=heroRepo.exist(heroRequest.getName(),heroRequest.getHeroClass().toString());
        if (a>0){
            throw new Exception("Hero exist");
        }else{
            HeroBase heroBase=heroBaseRepo.findByHeroClass(heroRequest.getHeroClass());
            Hero heros=new Hero();
            heros.getId();
            heros.setHeroClass(heroRequest.getHeroClass());
            heros.setName(heroRequest.getName());
            heros.setGold(0);
            heros.setLevel(1);
            heros.setAttack(heroBase.getAttack());
            heros.setArmor(heroBase.getArmor());
            heros.setAvatar(heroBase.getAvatar());
            heros.setHealth(heroBase.getHealth());
            heros.setMagic(heroBase.getMagic());
            heros.setBackpackSpace(heroBase.getBackpackSpace());
            heros.setSpell(heroBase.getSpell());
            heros.setWeapon(heroBase.getWeapon());
            heros.setAttackSpeed(heroBase.getAttackSpeed());
            heroRepo.save(heros);
            backpackService.create(heros);

            String username=getUserName(request,response);
            Optional<User> user=userRepository.findByUsername(username);
            Long UserId=user.get().getId();
            UserHero userHero=new UserHero();
            userHero.setHeroId(heros.getId());
            userHero.setUserId(UserId);
            userHeroRepo.save(userHero);
            return heros;
        }
    }
}
