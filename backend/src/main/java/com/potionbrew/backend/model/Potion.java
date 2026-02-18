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

}
