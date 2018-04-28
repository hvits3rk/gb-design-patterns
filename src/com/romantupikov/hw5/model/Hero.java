package com.romantupikov.hw5.model;

import com.romantupikov.hw5.state.IdleState;
import com.romantupikov.hw5.state.State;

public class Hero implements Character {

    private String animation;
    private String particles;

    private CharacterState event;
    private State state;

    public Hero() {
        this.state = new IdleState();
        handleEvent(CharacterState.IDLE);
    }

    private void update() {
        State newState = state.handleInput(this, event);
        if (newState != null) {
            state = newState;
        }
        state.update(this);
    }

    public void handleEvent(CharacterState event) {
        this.event = event;
        update();
    }

    @Override
    public void setAnimation(String animation) {
        this.animation = animation;
    }

    @Override
    public void setParticles(String particles) {
        this.particles = particles;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "animation='" + animation + '\'' +
                ", particles='" + particles + '\'' +
                '}';
    }
}
