package org.example.service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.example.dto.BuyRequest;
import org.example.model.Hero;
import org.example.model.Item;
import org.example.repository.BackpackItemRepo;
import org.example.repository.HeroRepo;
import org.example.repository.ItemRepo;
import org.example.security.JWTUtils;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CityService {
    private final ItemRepo itemRepo;
    private final HeroRepo heroRepo;
    private final BackpackItemService backpackItemService;
    private final JWTUtils jwtUtils;

    //losowanie itemow do sklepu
    @Scheduled(cron = "0 1 1 * * ?")
    public List<Item>showShop() {
        List<Long>random= random();

        List<Item> itemSet=new ArrayList<>();
        for(int i=0;i< random().size();i++){
            itemSet.add(itemRepo.getById(random.get(i))) ;
        }
        return itemSet;
    }
    public List<Long> random(){
        long quantity=itemRepo.count();
        List<Long> ids=new ArrayList<>();
        for(int i=0;i<5;i++){
            Long randomNumber=(long) ((Math.random() * ( quantity- 1)) + 1);
            ids.add(randomNumber);
        }

        return ids;
    }

    public Item buy(BuyRequest buyRequest, HttpServletRequest request,
                    HttpServletResponse response) throws Exception {

        Item item= itemRepo.getById(buyRequest.getItemId());
        Hero hero=heroRepo.getById(buyRequest.getHeroId());
        if(hero.getGold()>=item.getCost() && backpackItemService.checkItems(buyRequest.getHeroId())){
            int setGold= hero.getGold()-item.getCost();
            hero.setGold(setGold);
            heroRepo.save(hero);
            backpackItemService.addItem(item.getId(),hero.getId());
            return item;
        }else{
            throw new Exception("Za mało złota");
        }
    }


}
