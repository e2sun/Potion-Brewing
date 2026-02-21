package com.potionbrew.backend.controller;

import com.potionbrew.backend.dto.*;
import com.potionbrew.backend.service.PotionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/potions")
@CrossOrigin(origins = "http://localhost:4200")
public class PotionController {
    private final PotionService service;

    public PotionController(PotionService service){
        this.service = service;
    }

    @GetMapping
    public List<PotionResponse> getAll(){
        return service.getAllPotions();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PotionResponse> getOne(@PathVariable Long id){
        PotionResponse potion = service.getPotionById(id);
        if (potion == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(potion);  
    }

    @PostMapping
    public PotionResponse create(@RequestBody CreatePotionRequest req){
        return service.createPotion(req);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        boolean deleted = service.deletePotion(id);
        if (!deleted){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/ingredients")
    public ResponseEntity<PotionResponse> addIngredient(@PathVariable Long id, @RequestBody AddIngredientRequest req){
        PotionResponse updated = service.addIngredient(id, req);
        if (updated == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updated);
    }

    @PatchMapping("/{potionId}/ingredients/{ingredientId}/toggle")
    public ResponseEntity<PotionResponse> toggleIngredient(@PathVariable Long potionId, @PathVariable Long ingredientId){
        PotionResponse updated = service.toggleIngredient(potionId, ingredientId);
        if (updated == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updated); 
    }


    @GetMapping("/stats")
    public Map<String, Object> getStats(){
        List<PotionResponse> all = service.getAllPotions();
        
        long complete = 0;
        for (PotionResponse p: all){
            if (p.isBrewed()){
                complete++;
            }
        }

        Map<String, Object> stats = new HashMap<>();
        stats.put("totalPotions", all.size());
        stats.put("completedPotions", complete);
        stats.put("incompletePotions", all.size() - complete);
        stats.put("totalPoints", service.getTotalPoints());

        return stats;
    }

}