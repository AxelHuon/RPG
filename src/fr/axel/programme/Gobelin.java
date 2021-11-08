package fr.axel.programme;

public class Gobelin extends Monstre {

    private static final String name = "Gobelin";
    private static final double hp = 17;
    private static final double damage = 12;
    private static final double money = 7;
    private static final double xp = 21;

    public Gobelin() {
        super(name, hp, damage, money, xp);
    }
}
