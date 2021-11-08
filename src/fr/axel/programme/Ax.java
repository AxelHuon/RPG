package fr.axel.programme;

public class Ax extends Weapon {
    private static final String name = "Ax";
    private static final double damage = 17;
    private static final double price = 25;

    public Ax() {
        super(name, damage, price);
    }
}
