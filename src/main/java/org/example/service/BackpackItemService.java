package org.example.service;
import lombok.RequiredArgsConstructor;
import org.example.model.Backpack;
import org.example.model.BackpackItem;
import org.example.model.HeroBackpack;
import org.example.repository.BackpackItemRepo;
import org.example.repository.BackpackRepo;
import org.example.repository.HeroBackpackRepo;
import org.springframework.stereotype.Service;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class BackpackItemService {
    private final BackpackItemRepo backpackItemRepo;
    private final HeroBackpackRepo heroBackpackRepo;
    private final BackpackRepo backpackRepo;
    private HeroBackpack getHero(int heroId){
        return heroBackpackRepo.findByHeroId(heroId).orElse(null);
    }
    private Backpack getBackpack(Long backpackId){
        return backpackRepo.findById(backpackId).orElse(null);
    }
    public void addItem(Long itemId, int heroId) {
        HeroBackpack heroBackpack =getHero(heroId);
        BackpackItem backpackItem=new BackpackItem();
        backpackItem.setBackpackId((long) heroBackpack.getBackpackId());
        backpackItem.setItemId(itemId);
        backpackItemRepo.save(backpackItem);
        Backpack backpack=getBackpack(heroBackpack.getBackpackId());
        backpackRepo.save(backpack);
        setBackpackSpace(backpack);
    }
//setting your backpackSize
    private void setBackpackSpace(Backpack backpack) {
        int currentSpace=backpack.getCurrentSpace()-1;
        backpack.setCurrentSpace(currentSpace);
        System.out.println(backpack.getCurrentSpace());
        backpackRepo.save(backpack);
    }
//check if your backpack is full
    public boolean checkItems(int heroId) {
        HeroBackpack heroBackpack =getHero(heroId);
        int quantity=heroBackpackRepo.showSpace(heroBackpack.getBackpackId());
        System.out.println(quantity);
        if(quantity>0){
            return true;
        }else {
            return false;
        }

    }
}

