package com.challenge.games.blackJack;

import com.challenge.Card;
import com.challenge.Player;

import java.util.*;

public class BlackJackLogic {
    private static Hands hands;
    private static final Scanner scanner = new Scanner(System.in);

    public BlackJackLogic(int playerCount) {
        hands = new Hands(playerCount);
    }

    public void startGame() {
        boolean flag = true;

        while (flag) {

            while (true) {
                try {
                    play();
                    break;
                } catch (NoSuchElementException e) {
                    System.out.println("Acabaram as cartas do deck, embaralhando novamente...");
//                    deck1.addAll(garbage);
//                    garbage.clear();
//                    Collections.shuffle(deck1);
                    hands.fillDeckWithGarbage();
                    scanner.nextLine();
                }
            }


            System.out.println("-".repeat(30));
            System.out.println();
            System.out.print("Jogar novamente? (S/N)");
            String response = scanner.nextLine();
            if (response.equalsIgnoreCase("n")) {
                flag = false;
            } else {
                hands.clearHands();
                Card.printDeck(hands.getGarbage(), "Colocando as cartas no lixo", 1);

            }
        }


    }

    public static void play() {
        boolean flag = true;
        boolean dealerTurn = false;
//        dealHands(dealerHand, deck1, playerHand);
        hands.dealHands();

        while (flag) {
            scanner.nextLine();
            clearTerminal();
            showHands(dealerTurn);

            if (!dealerTurn) {

                dealerTurn = playerPlay();
                if (totalPoint(hands.getPlayer().get(0).getPlayerHand()) > 21) { // TODO change it to  receive more than 1 player
                    System.out.println("Player explodiu!");
                    flag = false;
                }
            } else {

                dealerPlay(totalPoint(hands.getPlayer().get(0).getPlayerHand()));

                if (totalPoint(hands.getDealerHand()) > 21) {
                    System.out.println("Dealer Explodiu");
                    flag = false;
                }
                if (totalPoint(hands.getDealerHand()) > totalPoint(hands.getPlayer().get(0).getPlayerHand()) && totalPoint(hands.getDealerHand()) <= 21) {
                    System.out.println("Dealer venceu!");
                    flag = false;
                }
                if (totalPoint(hands.getDealerHand()) == totalPoint(hands.getPlayer().get(0).getPlayerHand())) {
                    System.out.println("Empate");
                    flag = false;
                }
            }


        }
        showHands(dealerTurn);
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

    public static void showHands(Boolean dealerTurn) {
        if (!dealerTurn) {
            System.out.println("-------------------------");
            System.out.println("Dealer:");
            printDealerHand(hands.getDealerHand());
            System.out.println("Valor da mao: " + totalPoint(List.of(hands.getDealerHand().get(0))));

        } else {

            Card.printDeck(hands.getDealerHand(), "Dealer:", 1);
            System.out.println("Valor da mao: " + totalPoint(hands.getDealerHand()));

        }
//        Card.printDeck(playerHand, "Player: ", 1);
        hands.getPlayer().forEach(player -> {
            Card.printDeck(player.getPlayerHand(), player.toString() + " Hand", 1);
            System.out.println("Valor da mao: " + totalPoint(player.getPlayerHand()));
        });

//        System.out.println("Valor da mao: " + totalPoint(playerHand));
    }

//    public static void dealHands(List<Card> dealerHand, LinkedList<Card> deck, List<Card> playerHand) {
//        while (dealerHand.size() < 2) {
//            playerHand.add(deck.pop());
//            dealerHand.add(deck.pop());
//        }
//    }

    /**
     * Made this to play auto
     * basic it draws cards while point < 15
     *
     * @return
     */
    public static boolean playerPlay() {
        if (totalPoint(hands.getPlayer().get(0).getPlayerHand()) < 15) {
            hands.drawCard(hands.getPlayer().get(0).getPlayerHand());
        }
        // scanner.nextLine();

        return totalPoint(hands.getPlayer().get(0).getPlayerHand()) >= 15;
    }

    public static int dealerPlay(int playerPoint) {
        if (totalPoint(hands.getDealerHand()) < playerPoint) {
            hands.drawCard(hands.getDealerHand());
        }
        scanner.nextLine();
        return totalPoint(hands.getDealerHand());
    }

    public static void clearTerminal() {
        for (int i = 0; i < 30; i++) {
            System.out.println();
        }
    }
    // TODO create logic method for victory ( for multiple players)

}


