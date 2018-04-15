package com.romantupikov.hw3.factory.alternate;

import com.romantupikov.hw3.model.Character;
import com.romantupikov.hw3.model.CharacterRace;

public class CharacterFactoryAltImpl implements CharacterFactoryAlt {

    private CharacterRace characterRace;

    public CharacterFactoryAltImpl(CharacterRace characterRace) {
        this.characterRace = characterRace;
    }

    @Override
    public Character createSpearman(String name, int health) {
        Character character = new Character(name, health);
        character.setCharacterRace(characterRace);

        character.setClothes("Leather tunic");
        character.setWeapon("Spear");

        return character;
    }

    @Override
    public Character createSwordman(String name, int health) {
        Character character = new Character(name, health);
        character.setCharacterRace(characterRace);

        character.setClothes("Iron breastplate");
        character.setWeapon("Sword");

        return character;
    }

    @Override
    public Character createThief(String name, int health) {
        Character character = new Character(name, health);
        character.setCharacterRace(characterRace);

        character.setClothes("Cloth tunic");
        character.setWeapon("Dagger");

        return character;
    }
}
