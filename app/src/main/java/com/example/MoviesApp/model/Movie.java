package com.example.MoviesApp.model;

public class Movie {
    private String id;
    private String title;
    private String studio;
    private String thumbnailUrl;
    private double criticsRating;

    // Empty constructor required for Firestore
    public Movie() {}

    public Movie(String id, String title, String studio, String thumbnailUrl, double criticsRating) {
        this.id = id;
        this.title = title;
        this.studio = studio;
        this.thumbnailUrl = thumbnailUrl;
        this.criticsRating = criticsRating;
    }

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getStudio() { return studio; }
    public void setStudio(String studio) { this.studio = studio; }

    public String getThumbnailUrl() { return thumbnailUrl; }
    public void setThumbnailUrl(String thumbnailUrl) { this.thumbnailUrl = thumbnailUrl; }

    public double getCriticsRating() { return criticsRating; }
    public void setCriticsRating(double criticsRating) { this.criticsRating = criticsRating; }
}

