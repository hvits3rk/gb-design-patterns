package com.romantupikov.hw3;

import com.romantupikov.hw3.factory.CharacterClass;
import com.romantupikov.hw3.factory.CharacterFactory;
import com.romantupikov.hw3.factory.CharacterFactoryImpl;
import com.romantupikov.hw3.factory.alternate.CharacterFactoryAlt;
import com.romantupikov.hw3.factory.alternate.CharacterFactoryAltImpl;
import com.romantupikov.hw3.model.Character;
import com.romantupikov.hw3.model.CharacterRace;

public class MainHW3 {
    public static void main(String[] args) {
        CharacterFactory goblinFactory = new CharacterFactoryImpl(CharacterRace.GOBLIN);
        Character goblinSpearman = goblinFactory.create("Waagh", 12, CharacterClass.SPEARMAN);
        System.out.println(goblinSpearman);

        CharacterFactoryAlt humanFactoryAlt = new CharacterFactoryAltImpl(CharacterRace.HUMAN);
        Character humanThief = humanFactoryAlt.createThief("Dukku", 6);
        System.out.println(humanThief);

    }
}
