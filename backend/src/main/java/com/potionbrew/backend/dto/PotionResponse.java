package com.potionbrew.backend.dto;

import com.potionbrew.backend.model.Ingredient;
import com.potionbrew.backend.model.Potion;

import java.time.LocalDateTime;
import java.util.List;

public class PotionResponse {
    private Long id;
    private String title;
    private String description;
    private boolean brewed;
    private LocalDateTime createdAt;
    private List<Ingredient> ingredients;

    private int completionPercentage;
    private int completedCount;
    private int totalCount;
    private int pointsEarned;

    public PotionResponse() {}

    public static PotionResponse fromPotion(Potion potion) {
        PotionResponse response = new PotionResponse();
        response.setId(potion.getId());
        response.setTitle(potion.getTitle());
        response.setDescription(potion.getDescription());
        response.setBrewed(potion.isBrewed());
        response.setCreatedAt(potion.getCreatedAt());
        response.setIngredients(potion.getIngredients());
        response.setCompletionPercentage(potion.getCompletionPercentage());
        response.setCompletedCount(potion.getCompletedCount());
        response.setTotalCount(potion.getIngredients() == null ? 0 : potion.getIngredients().size());
        response.setPointsEarned(potion.getPointsEarned());
        return response;
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

    public int getCompletionPercentage(){
        return completionPercentage;
    }

    public int getCompletedCount(){
        return completedCount;
    }

    public int getTotalCount(){
        return totalCount;
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

    public void setBrewed(boolean brewed){
        this.brewed = brewed;
    }

    public void setCreatedAt(LocalDateTime createdAt){
        this.createdAt = createdAt;
    }
    
    public void setIngredients(List<Ingredient> ingredients){
        this.ingredients = ingredients;
    }

    public void setCompletionPercentage(int completionPercentage){
        this.completionPercentage = completionPercentage;
    }

    public void setCompletedCount(int completedCount){
        this.completedCount = completedCount;
    }

    public void setTotalCount(int totalCount){
        this.totalCount = totalCount;
    }

    public void setPointsEarned(int pointsEarned){
        this.pointsEarned = pointsEarned;
    }

}