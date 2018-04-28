package com.romantupikov.hw5.state;

import com.romantupikov.hw5.model.Character;
import com.romantupikov.hw5.model.CharacterState;

public class RunningState implements State {

    @Override
    public State handleInput(Character character, CharacterState event) {
        switch (event) {
            case IDLE:
                return new IdleState();
        }
        return null;
    }

    @Override
    public boolean update(Character character) {
        character.setAnimation("Running");
        character.setParticles("Dust");
        return false;
    }
}
