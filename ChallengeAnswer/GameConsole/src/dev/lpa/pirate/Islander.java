package dev.lpa.pirate;

public final class Islander extends Combatent {
    public Islander(String name, Weapon weapon) {
        super(name);
        setCurrentWeapon(weapon);
    }
}
