package com.challenge.games.blackJack;

import com.challenge.Card;
import com.challenge.Player;

import java.util.*;

public class Hands {
    private int playerCount;
    private final LinkedList<Card> deck = new LinkedList<>(Card.getStandardDeck());
    List<Card> garbage = new ArrayList<>();
    private List<Card> dealerHand;
    private List<Player> player;

    public LinkedList<Card> getDeck() {
        return deck;
    }

    public List<Card> getGarbage() {
        return garbage;
    }

    /**
     * Also shuffle and cut deck
     */
    public void fillDeckWithGarbage(){
        deck.addAll(garbage);
        garbage.clear();
        shuffleAndCut();
    }

    public void shuffleAndCut(){
        Collections.shuffle(deck);
        int randomMiddle = new Random().nextInt(15, 35);
        Collections.rotate(deck,randomMiddle);
    }

    public Hands(int playerCount) {

        this.playerCount = playerCount;
        dealerHand = new ArrayList<>();
        player = new ArrayList<>();
        createPlayers(playerCount);
    }

    private void createPlayers(int playerCount) {
        for (int i = 0; i < playerCount; i++) {
            player.add(new Player());
        }
        dealerHand = new ArrayList<>();
    }

    public void dealHands(){
        while (dealerHand.size() < 2) {
            dealerHand.add(deck.pop());
            for (int i = 0; i < playerCount; i++) {
                player.get(i).addCard(deck.pop());
            }
        }
    }

    public void drawCard(List<Card> hand) {
        hand.add(deck.pop());
    }

    public void clearHands(){
        garbage.addAll(dealerHand);
        dealerHand.clear();

        player.forEach(p -> p.addAndRemoveAll(garbage) );

    }

    @Override
    public String toString() {
        Card.printDeck(dealerHand,"Dealer",1);

        for (Player p : this.player) {
            System.out.println(p);
        }
        return "";
    }

    public List<Card> getDealerHand() {
        return dealerHand;
    }

    public List<Player> getPlayer() {
        return player;
    }
}
