package com.ghostdev.springboot.thymeleafdemo.model;

import java.util.List;

public class Student {

    private String firstName;
    private String lastName;
    private String country;
    private String favoriteProgramLanguage;
    private List<String> favoriteOperationalSystem;

    /* Construtor padrão (vazio) */
    public Student () {

    }
    
    /* Getters and Setters: é extremamente importante configurar os getters e setters 
     * para que o Thymeleaf funcione corretamente;
     */
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getFavoriteProgramLanguage() {
        return favoriteProgramLanguage;
    }

    public void setFavoriteProgramLanguage(String favoriteProgramLanguage) {
        this.favoriteProgramLanguage = favoriteProgramLanguage;
    }

    public List<String> getFavoriteOperationalSystem() {
        return favoriteOperationalSystem;
    }

    public void setFavoriteOperationalSystem(List<String> favoriteOperationalSystem) {
        this.favoriteOperationalSystem = favoriteOperationalSystem;
    }

    @Override
    public String toString() {
        return "Student [firstName=" + firstName + ", lastName=" + lastName + ", country=" + country
                + ", favoriteProgramLanguage=" + favoriteProgramLanguage + ", favoriteOperationalSystem="
                + favoriteOperationalSystem + "]";
    }

    
}