package dev.lpa;

import dev.lpa.game.GameConsole;
import dev.lpa.game.ShooterGame;
import dev.lpa.game.Weapon;

public class Main {
    public static void main(String[] args) {

//        var console = new GameConsole<>(new ShooterGame("The Shootout Game"));
//
//        int playerIndex = console.addPlayer();
//        console.playGame(playerIndex);
//

        Weapon weapon = Weapon.SWORD;

        System.out.println(weapon);

        System.out.println("You took " + weapon.getHitPoints() + " damage");

    }
}
