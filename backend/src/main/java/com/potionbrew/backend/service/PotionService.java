package com.potionbrew.backend.service;

import com.potionbrew.backend.dto.*;
import com.potionbrew.backend.model.*;
import com.potionbrew.backend.repository.PotionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;

@Service
public class PotionService {
    private final PotionRepository repo;

    public PotionService(PotionRepository repo){
        this.repo = repo;
    }

    // create a Potion Response
    public PotionResponse createPotion(CreatePotionRequest req) {
        Potion potion = new Potion();
        potion.setTitle(req.getTitle());
        potion.setDescription(req.getDescription());
        return PotionResponse.fromPotion(repo.save(potion));
    }

    // get a list of all potions
    public List<PotionResponse> getAllPotions(){
        List<Potion> potions = repo.findAll();
        List<PotionResponse> responses = new ArrayList<>();
        for (Potion p: potions){
            responses.add(PotionResponse.fromPotion(p));
        }
        return responses;
    }

    // get a specific potion by ID
    public PotionResponse getPotionById(Long id) {
        Potion potion = repo.findByIdOrNull(id);
        if (potion == null){
            return null;
        }
        return PotionResponse.fromPotion(potion);
    }

    // delete a specific potion by ID
    public boolean deletePotion(Long id){
        Potion potion = repo.findByIdOrNull(id);
        if (potion == null){
            return false;
        }
        repo.deleteById(id);
        return true;
    }

    // add an ingredient to the potion
    public PotionResponse addIngredient(Long potionId, AddIngredientRequest req){
        Ingredient ing = new Ingredient();
        ing.setTitle(req.getTitle());
        ing.setDeadline(req.getDeadline());

        Ingredient added = repo.addIngredient(potionId, ing);
        if (added == null){
            return null;
        }
        Potion potion = repo.findByIdOrNull(potionId);
        return PotionResponse.fromPotion(potion);
    }

    // mark an ingredient as completed in the potion
    public PotionResponse toggleIngredient(Long potionId, Long ingredientId) {
        boolean success = repo.toggleIngredient(potionId, ingredientId);
        if (!success){
            return null;
        }

        Potion potion = repo.findByIdOrNull(potionId);
        if (potion == null) {
            return null;
        }
        return PotionResponse.fromPotion(potion);
    }

    // return the number of total points the user has 
    public int getTotalPoints(){
        int total = 0;
        List<Potion> potions = repo.findAll();
        for (Potion p: potions){
            total += p.getPointsEarned();
        }
        return total;
    }
}

