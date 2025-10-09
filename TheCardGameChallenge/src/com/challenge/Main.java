package com.challenge;

import java.util.*;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        List<Card> deck = new ArrayList<>();
        deck = Card.getStandardDeck();

        Collections.shuffle(deck);

        LinkedList<Card> deck1 = new LinkedList<>(deck);
        List<Card> dealerHand = new ArrayList<>();
        List<Card> playerHand = new ArrayList<>();
        dealHands(dealerHand, deck1, playerHand);

        boolean flag = true;
        boolean dealerTurn = false;

        while (flag) {
            clearTerminal();
            showHands(playerHand, dealerHand, dealerTurn);

            if (!dealerTurn) {

                dealerTurn = playerPlay(playerHand, deck1);
                if (totalPoint(playerHand) > 21) {
                    System.out.println("Player explodiu!");
                    flag = false;
                }
            } else {

                dealerPlay(dealerHand, deck1, totalPoint(playerHand));
                if (totalPoint(dealerHand) > 21) {
                    System.out.println("Dealer Explodiu");
                    flag = false;
                }
                if (totalPoint(dealerHand) > totalPoint(playerHand) && totalPoint(dealerHand) <= 21) {
                    System.out.println("Dealer venceu!");
                    flag = false;
                }
                if (totalPoint(dealerHand ) == totalPoint(playerHand)) {
                    System.out.println("Empate");
                    flag = false;
                }
            }



        }
        showHands(playerHand, dealerHand, dealerTurn);


    }

    public static void printDealerHand(List<Card> dealerHand) {
        System.out.println(dealerHand.get(0));
    }

    public static int totalPoint(List<Card> hand) {
        int response = 0;
        boolean hasA = false;
        for (Card value : hand) {
            if (value.getFace().equalsIgnoreCase("J") ||
                    value.getFace().equalsIgnoreCase("Q") ||
                    value.getFace().equalsIgnoreCase("K")) {
                response += 10;
            } else if (value.getFace().equalsIgnoreCase("A")) {
                hasA = true;
            } else {
                response += Integer.parseInt(value.getFace());
            }

        }

        // logic for A's

        if (hasA) {
            for (Card card : hand) {

                if (card.getFace().equalsIgnoreCase("A")) {

                    if (response + 11 > 21) {
                        response += 1; // as vale 1
                    } else {
                        response += 11;
                    }
                }
            }
        }
        return response;
    }

    public static void showHands(List<Card> playerHand, List<Card> dealerHand, Boolean dealerTurn) {
        if (!dealerTurn) {
            System.out.println("-------------------------");
            System.out.println("Dealer:");
            printDealerHand(dealerHand);
            System.out.println("Valor da mao: " + totalPoint(List.of(dealerHand.get(0))));

        } else {

            Card.printDeck(dealerHand, "Dealer:", 1);
            System.out.println("Valor da mao: " + totalPoint(dealerHand));

        }
        Card.printDeck(playerHand, "Player: ", 1);
        System.out.println("Valor da mao: " + totalPoint(playerHand));
    }

    public static void dealHands(List<Card> dealerHand, LinkedList<Card> deck, List<Card> playerHand) {
        while (dealerHand.size() < 2) {
            playerHand.add(deck.pop());
            dealerHand.add(deck.pop());
        }
    }

    public static boolean playerPlay(List<Card> playerHand, LinkedList<Card> deck) {
        if (totalPoint(playerHand) < 15) {
            playerHand.add(deck.pop());
        }
            scanner.nextLine();

        return totalPoint(playerHand) >= 15;
    }

    public static int dealerPlay(List<Card> dealerHand, LinkedList<Card> deck, int playerPoint) {
        if (totalPoint(dealerHand) < playerPoint) {
            dealerHand.add(deck.pop());
        }
            scanner.nextLine();
        return totalPoint(dealerHand);
    }

    public static void clearTerminal() {
        for (int i = 0; i < 30; i++) {
            System.out.println();
        }
    }
}
