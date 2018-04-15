package com.romantupikov.hw3.factory;

import com.romantupikov.hw3.model.Character;
import com.romantupikov.hw3.model.CharacterRace;

public class CharacterFactoryImpl implements CharacterFactory {

    private CharacterRace characterRace;

    public CharacterFactoryImpl(CharacterRace characterRace) {
        this.characterRace = characterRace;
    }

    @Override
    public Character create(String name, int health, CharacterClass characterClass) {
        Character character = new Character(name, health);
        character.setCharacterRace(characterRace);
        switch (characterClass) {
            case SPEARMAN:
                character.setClothes("Leather tunic");
                character.setWeapon("Spear");
                break;
            case SWORDMAN:
                character.setClothes("Iron breastplate");
                character.setWeapon("Sword");
                break;
            case THIEF:
                character.setClothes("Cloth tunic");
                character.setWeapon("Dagger");
                break;
        }
        return character;
    }
}
