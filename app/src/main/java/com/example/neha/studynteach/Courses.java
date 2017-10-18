package com.example.neha.studynteach;



public class Courses {
    private String name;
    private int numOfSongs;
    private int thumbnail;

    public Courses() {
    }

    public Courses(String name, int numOfSongs, int thumbnail) {
        this.name = name;
        this.numOfSongs = numOfSongs;
        this.thumbnail = thumbnail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTopic() {
        return numOfSongs;
    }

    public void setTopic(int numOfSongs) {
        this.numOfSongs = numOfSongs;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }
}