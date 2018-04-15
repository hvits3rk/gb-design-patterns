package com.romantupikov.hw3.factory;

import com.romantupikov.hw3.model.Character;

public interface CharacterFactory {
    Character create(String name, int health, CharacterClass characterClass);
}
