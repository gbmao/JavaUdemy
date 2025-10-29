package dev.lpa.pirate;

public enum Weapon {

    KNIFE(1,2),
    MACHETE(2,3),
    AXE(4,4),
    SWORD(5,6);

    private final int minLevel;

    private final int hitPoints;

    Weapon(int minLevel, int hitPoints) {
        this.minLevel = minLevel;
        this.hitPoints = hitPoints;
    }

    public int getMinLevel() {
        return minLevel;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    //Item description

    @Override
    public String toString() {
        return this.name().toLowerCase() + " : min lvl: " + this.minLevel + " damage: " + this.hitPoints;
    }
}
