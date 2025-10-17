package com.challenge;

public enum PlayersName {

    PLAYER_ONE, PLAYER_TWO, PLAYER_TREE, PLAYER_FOUR;


    @Override
    public String toString() {
        return this.name().replace("_"," ").toLowerCase();
    }
}
