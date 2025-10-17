package com.challenge;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private List<Card> playerHand = new ArrayList<>();
    private static int playerNumber = -1; // TODO change it to be more "universal" (

    public Player() { // cria player usando enum como nome
        playerNumber++;
        this.name = PlayersName.values()[playerNumber].toString();
    }

    public Player(String name) { // possiblidade de criar nome propio
        this.name = name;

    }

    public List<Card> getPlayerHand() {
        return playerHand;
    }

    @Override
    public String toString() {
//        Card.printDeck(playerHand, name, 1);
        return name;
    }

    public void addCard(Card card) {
        playerHand.add(card);
    }

    public void addAndRemoveAll(List<Card> list) {
        list.addAll(playerHand);
        playerHand.clear();
    }
}
