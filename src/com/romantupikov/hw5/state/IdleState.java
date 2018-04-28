package com.romantupikov.hw5.state;

import com.romantupikov.hw5.model.Character;
import com.romantupikov.hw5.model.CharacterState;

public class IdleState implements State {

    @Override
    public State handleInput(Character character, CharacterState event) {
        switch (event) {
            case RUNNING:
                return new RunningState();
        }
        return null;
    }

    @Override
    public boolean update(Character character) {
        character.setAnimation("Idle");
        character.setParticles("None");
        return false;
    }
}
