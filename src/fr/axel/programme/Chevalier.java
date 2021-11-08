package fr.axel.programme;

public class Chevalier extends Player {
    private static final double hp = 45;
    private static final double ratiodamage = 1.45;
    private static final double money = 50;
    private static final double xp = 0;
    private static final String type = "Chevalier";
    private static final int level = 1;

    public Chevalier(String name) {
        super(name, hp, ratiodamage, money, xp, type, level);
    }
}
