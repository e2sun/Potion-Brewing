package com.potionbrew.backend.repository;

import com.potionbrew.backend.model.Ingredient;
import com.potionbrew.backend.model.Potion;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong; // thread safe count variable

@Repository
public class PotionRepository {
    private final Map<Long, Potion> potions = new LinkedHashMap<>();
    private final AtomicLong potionIdCounter = new AtomicLong(1);
    private final AtomicLong ingredientIdCounter = new AtomicLong(1);

    // save new potion to our list of potions
    public Potion save(Potion potion){
        if (potion.getId() == null){
            potion.setId(potionIdCounter.getAndIncrement());
        }
        potions.put(potion.getId(), potion);
        return potion;
    }

    // find a potion by an ID
    public Potion findByIdOrNull(Long id){
        return potions.get(id);
    }

    // find all potions
    public List<Potion> findAll(){
        return new ArrayList<>(potions.values());
    }

    // delete a potion by their ID
    public void deleteById(Long id){
        potions.remove(id);
    }

    // add new ingredient to a specific potion
    public Ingredient addIngredient(Long potionId, Ingredient ingredient){
        Potion potion = potions.get(potionId);
        if (potion == null){
            return null;
        }
        ingredient.setId(ingredientIdCounter.getAndIncrement());
        ingredient.setPotionId(potionId);
        ingredient.setOrderIndex(potion.getIngredients().size());
        potion.getIngredients().add(ingredient);
        return ingredient;
    }

    // Check off an ingredient (task) to completed
    public boolean toggleIngredient(Long potionId, Long ingredientId){
        Potion potion = potions.get(potionId);
        if (potion == null){
            return false;
        }
        for (Ingredient ing: potion.getIngredients()){
            if (ing.getId().equals(ingredientId)){
                ing.setCompleted(!ing.isCompleted());

                // award points and mark brew fully complete
                if (potion.isFullyBrewed()){
                    potion.setBrewed(true);
                    potion.setPointsEarned(potion.getIngredients().size()*10);
                }
                
                return true;
            }
        }

        return false;

    }

}