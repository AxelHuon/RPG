package fr.axel.programme;

public class Dragon extends Monstre {

    private static final String name = "Dragon";
    private static final double hp = 100;
    private static final double damage = 10;
    private static final double money = 8;
    private static final double xp = 20;

    public Dragon() {
        super(name, hp, damage, money, xp);
    }
}
