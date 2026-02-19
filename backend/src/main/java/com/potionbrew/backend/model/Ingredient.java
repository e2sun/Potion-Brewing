package com.potionbrew.backend.model;

import java.time.LocalDateTime;

public class Ingredient {
    private Long id;
    private Long potionId;
    private String title;
    private boolean completed;
    private Integer orderIndex;
    private LocalDateTime createdAt;

    public Ingredient() {
        this.createdAt = LocalDateTime.now();
        this.completed = false;
    }

    // Getters

    public Long getId() {
        return id;
    }

    public Long getPotionId() {
        return potionId;
    }

    public String getTitle() {
        return title;
    }

    public boolean isCompleted(){
        return completed;
    }

    public Integer getOrderIndex() {
        return orderIndex;
    }

    public LocalDateTime getCreatedAt(){
        return createdAt;
    }

    public void setId(Long id){
        this.id = id;
    }

    public void setPotionId(Long potionId) {
        this.potionId = potionId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCompleted(boolean completed){
        this.completed = completed;
    }

    public void setOrderIndex(Integer orderIndex) {
        this.orderIndex = orderIndex;
    }

    public void setCreatedAt(LocalDateTime createdAt){
        this.createdAt = createdAt;
    }
}