package com.romantupikov.hw5.state;

import com.romantupikov.hw5.model.Character;
import com.romantupikov.hw5.model.CharacterState;

public interface State {

    State handleInput(Character character, CharacterState event);

    boolean update(Character character);

}
