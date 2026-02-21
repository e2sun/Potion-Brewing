package com.potionbrew.backend.dto;

import java.time.LocalDate;

public class AddIngredientRequest {
    private String title;
    private LocalDate deadline;

    public AddIngredientRequest(){}

    public AddIngredientRequest(String title){
        this.title = title;
    }

    // Getter

    public String getTitle(){
        return this.title;
    }

    public LocalDate getDeadline(){
        return this.deadline;
    }

    // Setter

    public void setTitle(String title){
        this.title = title;
    }

    public void setDeadline(LocalDate deadline){
        this.deadline = deadline;
    }

}