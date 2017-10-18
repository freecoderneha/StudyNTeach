package com.example.neha.studynteach;

public class PickItem {
    int id;
    String name;
    String description;
    int likes;
    int thumbnail;

    public PickItem(String name,String description,int likes,int thumbnail) {
        this.name=name;
        this.description=description;
        this.likes=likes;
        this.thumbnail=thumbnail;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }
}