package com.romantupikov.hw5;

import com.romantupikov.hw5.model.CharacterState;
import com.romantupikov.hw5.model.Hero;

public class MainHW5 {
    public static void main(String[] args) {
        Hero hero = new Hero();
        System.out.println(hero);

        hero.handleEvent(CharacterState.RUNNING);
        System.out.println(hero);

        hero.handleEvent(CharacterState.IDLE);
        System.out.println(hero);
    }
}
