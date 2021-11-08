package fr.axel.programme;

import java.util.ArrayList;

public class Ninja extends Player {
    private static final double hp = 50;
    private static final double ratiodamage = 1.5;
    private static final double money = 50;
    private static final double xp = 0;
    private static final String type = "Ninja";
    private static final int level = 1;


    public Ninja(String name) {
        super(name, hp, ratiodamage, money, xp, type, level);
    }
}
