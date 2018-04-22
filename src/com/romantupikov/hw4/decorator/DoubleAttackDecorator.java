package com.romantupikov.hw4.decorator;

import com.romantupikov.hw4.model.Weapon;

public class DoubleAttackDecorator implements Weapon {

    private Weapon weapon;

    public DoubleAttackDecorator(Weapon weapon) {
        this.weapon = weapon;
    }

    @Override
    public void attack() {
        weapon.attack();
        System.out.println("Twice!");
    }
}
