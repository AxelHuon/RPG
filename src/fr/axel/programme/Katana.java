package fr.axel.programme;

public class Katana extends Weapon {
    private static final String name = "Katana";
    private static final double damage = 15;
    private static final double price = 20;

    public Katana() {
        super(name, damage, price);
    }
}
