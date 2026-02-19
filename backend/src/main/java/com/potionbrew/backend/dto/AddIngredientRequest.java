package com.potionbrew.backend.dto;

public class AddIngredientRequest {
    private String title;

    public AddIngredientRequest(){}

    public AddIngredientRequest(String title){
        this.title = title;
    }

    // Getter

    public String getTitle(){
        return this.title;
    }

    // Setter

    public void setTitle(String title){
        this.title = title;
    }

}