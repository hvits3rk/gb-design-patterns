package com.romantupikov.hw3.factory.alternate;

import com.romantupikov.hw3.model.Character;

public interface CharacterFactoryAlt {
    Character createSpearman(String name, int health);
    Character createSwordman(String name, int health);
    Character createThief(String name, int health);
}
