package com.potionbrew.backend.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Potion {
    private Long id;
    private String title;
    private String description;
    private boolean brewed;
    private LocalDateTime createdAt;
    private List<Ingredient> ingredients = new ArrayList<>();
    private int pointsEarned;

    public Potion() {
        this.createdAt = LocalDateTime.now();
        this.brewed = false;
        this.pointsEarned = 0;
    }

    // Getters

    public Long getId(){
        return id;
    }

    public String getTitle(){
        return title;
    }

    public String getDescription(){
        return description;
    }

    public boolean isBrewed(){
        return brewed;
    }

    public LocalDateTime getCreatedAt(){
        return createdAt;
    }

    public List<Ingredient> getIngredients(){
        return ingredients;
    }

    public int getPointsEarned(){
        return pointsEarned;
    }

    // Setters

    public void setId(Long id){
        this.id = id;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public void setBrewed(boolean brewed) {
        this.brewed = brewed;
    }

    public void setCreatedAt(LocalDateTime createdAt){
        this.createdAt = createdAt;
    }

    public void setIngredients(List<Ingredient> ingredients){
        this.ingredients = (ingredients == null) ? new ArrayList<>(): ingredients;
    }

    public void setPointsEarned(int pointsEarned){
        this.pointsEarned = pointsEarned;
    }

    // Helper Methods
    
    // Return the total number of completed ingredients in a potion
    public int getCompletedCount(){
        int completedCount = 0;
        for (int i = 0; i < ingredients.size(); i++){
            Ingredient ing = ingredients.get(i);
            if (ing != null && ing.isCompleted()){
                completedCount+=1;
            }
        }
        return completedCount;
    }

    // Return the potion completion percentage
    public int getCompletionPercentage(){
        int totalIngredients = ingredients.size();
        if (totalIngredients == 0) {
            return 0;
        }
        int completedCount = getCompletedCount();
        return (completedCount * 100) / totalIngredients;
    }

    // Returns true if tasks are all completed, false otherwise
    public boolean isFullyBrewed(){
        int totalIngredients = ingredients.size();
        if (totalIngredients == 0){
            return false;
        }
        return totalIngredients == getCompletedCount();
    }
  
}
