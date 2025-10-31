package dev.lpa.pirate;

public final class Soldier extends Combatent {
    public Soldier(String name, Weapon weapon) {
        super(name);
        setCurrentWeapon(weapon);
    }
}
