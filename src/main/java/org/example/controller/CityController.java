package org.example.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.example.dto.BuyRequest;
import org.example.model.Item;
import org.example.service.CityService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@PreAuthorize("hasRole('PLAYER')")
@RestController
@RequestMapping("/game/city")
@RequiredArgsConstructor
public class CityController {
    private final CityService cityService;
    private final SmithController smithController;
    @GetMapping("/shop")
    public List<Item>shop(){return cityService.showShop();}

    @PostMapping("/shop/buy")
    public Item but(@RequestBody BuyRequest buyRequest,
                    HttpServletRequest request,
                    HttpServletResponse response) throws Exception {
        return cityService.buy(buyRequest,request,response);
    }
}
