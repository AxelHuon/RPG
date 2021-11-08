package fr.axel.programme;

public class Sword extends Weapon {
    private static final String name = "Sword";
    private static final double damage = 12;
    private static final double price = 14;

    public Sword() {
        super(name, damage, price);
    }
}
