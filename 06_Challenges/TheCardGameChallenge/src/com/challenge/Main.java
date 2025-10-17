package com.challenge;

import com.challenge.games.blackJack.BlackJackLogic;
import com.challenge.games.blackJack.Hands;

import java.util.*;

public class Main {

//    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        BlackJackLogic blackjack = new BlackJackLogic(1); // TODO a menu asking for number of players
        blackjack.startGame();


//        List<Card> deck = new ArrayList<>();
//
//
//        // teste
//
//        deck = Card.getStandardDeck();
////        Player novo = new Player(deck);
////        System.out.println(novo);
//
//        Hands nava = new Hands(3);
//
//        nava.shuffleAndCut();
//        Card.printDeck(nava.getDeck(), "deck", 4);
//        nava.dealHands();
//        System.out.println(nava);
//        Card.printDeck(nava.getDeck(), "deck", 4);
//
//        nava.clearHands();
//        System.out.println(nava.getGarbage());
//        nava.dealHands();
//        System.out.println(nava);
//
//        nava.clearHands();
//        nava.fillDeckWithGarbage();
//        System.out.println("lixo: ");
//        System.out.println(nava.getGarbage());
//
//
//        Card.printDeck(nava.getDeck(), "deck", 4);
//
//
//
//        // fim do teste
//
//        Collections.shuffle(deck);
//
//        LinkedList<Card> deck1 = new LinkedList<>(deck);
//        List<Card> dealerHand = new ArrayList<>();
//        List<Card> playerHand = new ArrayList<>();
//        List<Card> garbage = new ArrayList<>();
//
//        boolean flag = true;
//
//        while (flag) {
//
//            while (true) {
//                try {
//                    play(dealerHand, playerHand, deck1);
//                    break;
//                } catch (NoSuchElementException e) {
//                    System.out.println("Acabaram as cartas do deck, embaralhando novamente...");
//                    deck1.addAll(garbage);
//                    garbage.clear();
//                    Collections.shuffle(deck1);
//                    scanner.nextLine();
//                }
//            }
//
//
//            System.out.println("-".repeat(30));
//            System.out.println();
//            System.out.print("Jogar novamente? (S/N)");
//            String response = scanner.nextLine();
//            if (response.equalsIgnoreCase("n")) {
//                flag = false;
//            } else {
//                garbage.addAll(dealerHand);
//                garbage.addAll(playerHand);
//                Card.printDeck(garbage, "Colocando as cartas no lixo", 1);
//                dealerHand.clear();
//                playerHand.clear();
//            }
//        }
//
//
//    }
//
////    public static void play(List<Card> dealerHand, List<Card> playerHand, LinkedList<Card> deck1) {
////        boolean flag = true;
////        boolean dealerTurn = false;
////        dealHands(dealerHand, deck1, playerHand);
////
////        while (flag) {
////            scanner.nextLine();
////            clearTerminal();
////            showHands(playerHand, dealerHand, dealerTurn);
////
////            if (!dealerTurn) {
////
////                dealerTurn = playerPlay(playerHand, deck1);
////                if (totalPoint(playerHand) > 21) {
////                    System.out.println("Player explodiu!");
////                    flag = false;
////                }
////            } else {
////
////                dealerPlay(dealerHand, deck1, totalPoint(playerHand));
////
////                if (totalPoint(dealerHand) > 21) {
////                    System.out.println("Dealer Explodiu");
////                    flag = false;
////                }
////                if (totalPoint(dealerHand) > totalPoint(playerHand) && totalPoint(dealerHand) <= 21) {
////                    System.out.println("Dealer venceu!");
////                    flag = false;
////                }
////                if (totalPoint(dealerHand) == totalPoint(playerHand)) {
////                    System.out.println("Empate");
////                    flag = false;
////                }
////            }
////
////
////        }
////        showHands(playerHand, dealerHand, dealerTurn);
////    }
//
//    public static void printDealerHand(List<Card> dealerHand) {
//        System.out.println(dealerHand.get(0));
//    }
//
//    public static int totalPoint(List<Card> hand) {
//        int response = 0;
//        boolean hasA = false;
//        for (Card value : hand) {
//            if (value.getFace().equalsIgnoreCase("J") ||
//                    value.getFace().equalsIgnoreCase("Q") ||
//                    value.getFace().equalsIgnoreCase("K")) {
//                response += 10;
//            } else if (value.getFace().equalsIgnoreCase("A")) {
//                hasA = true;
//            } else {
//                response += Integer.parseInt(value.getFace());
//            }
//
//        }
//
//        // logic for A's
//
//        if (hasA) {
//            for (Card card : hand) {
//
//                if (card.getFace().equalsIgnoreCase("A")) {
//
//                    if (response + 11 > 21) {
//                        response += 1; // as vale 1
//                    } else {
//                        response += 11;
//                    }
//                }
//            }
//        }
//        return response;
//    }
//
//    public static void showHands(List<Card> playerHand, List<Card> dealerHand, Boolean dealerTurn) {
//        if (!dealerTurn) {
//            System.out.println("-------------------------");
//            System.out.println("Dealer:");
//            printDealerHand(dealerHand);
//            System.out.println("Valor da mao: " + totalPoint(List.of(dealerHand.get(0))));
//
//        } else {
//
//            Card.printDeck(dealerHand, "Dealer:", 1);
//            System.out.println("Valor da mao: " + totalPoint(dealerHand));
//
//        }
//        Card.printDeck(playerHand, "Player: ", 1);
//        System.out.println("Valor da mao: " + totalPoint(playerHand));
//    }
//
//    public static void dealHands(List<Card> dealerHand, LinkedList<Card> deck, List<Card> playerHand) {
//        while (dealerHand.size() < 2) {
//            playerHand.add(deck.pop());
//            dealerHand.add(deck.pop());
//        }
//    }
//
//    public static boolean playerPlay(List<Card> playerHand, LinkedList<Card> deck) {
//        if (totalPoint(playerHand) < 15) {
//            playerHand.add(deck.pop());
//        }
//       // scanner.nextLine();
//
//        return totalPoint(playerHand) >= 15;
//    }
//
//    public static int dealerPlay(List<Card> dealerHand, LinkedList<Card> deck, int playerPoint) {
//        if (totalPoint(dealerHand) < playerPoint) {
//            dealerHand.add(deck.pop());
//        }
//        scanner.nextLine();
//        return totalPoint(dealerHand);
//    }
//
//    public static void clearTerminal() {
//        for (int i = 0; i < 30; i++) {
//            System.out.println();
//        }
//    }
    }}
