package fr.axel.programme;

public class Viking extends Player {
    private static final double hp = 35;
    private static final double ratiodamage = 1.9;
    private static final double money = 50;
    private static final double xp = 0;
    private static final String type = "Viking";
    private static final int level = 1;

    public Viking(String name) {
        super(name, hp, ratiodamage, money, xp, type, level);
    }
}
