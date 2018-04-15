package com.romantupikov.hw3.model;

public class Character {
    private CharacterRace characterRace;
    private String name;
    private int health;
    private String weapon;
    private String clothes;

    public Character(String name, int health) {
        this.name = name;
        this.health = health;
    }

    public CharacterRace getCharacterRace() {
        return characterRace;
    }

    public void setCharacterRace(CharacterRace characterRace) {
        this.characterRace = characterRace;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public String getClothes() {
        return clothes;
    }

    public void setClothes(String clothes) {
        this.clothes = clothes;
    }

    @Override
    public String toString() {
        return "Character{" +
                "characterRace=" + characterRace +
                ", name='" + name + '\'' +
                ", health=" + health +
                ", weapon='" + weapon + '\'' +
                ", clothes='" + clothes + '\'' +
                '}';
    }
}
