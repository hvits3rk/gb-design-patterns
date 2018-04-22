package com.romantupikov.hw4;

import com.romantupikov.hw4.decorator.DoubleAttackDecorator;
import com.romantupikov.hw4.model.Sword;
import com.romantupikov.hw4.model.Weapon;

public class MainHW4 {
    public static void main(String[] args) {
        Weapon sword = new Sword();
        sword.attack();

        DoubleAttackDecorator attackDecorator = new DoubleAttackDecorator(sword);
        attackDecorator.attack();
    }
}
