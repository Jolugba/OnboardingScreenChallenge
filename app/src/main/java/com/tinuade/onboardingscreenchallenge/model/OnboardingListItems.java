package com.tinuade.onboardingscreenchallenge.model;

public class OnboardingListItems {
    private String title, description;
    private int image;

    public OnboardingListItems(String title, String description, int image) {
        this.title = title;
        this.description = description;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }


    public String getDescription() {
        return description;
    }


    public int getImage() {
        return image;
    }


}
