package fr.axel.programme;

import java.util.ArrayList;

public class Samurai extends Player {
    private static final double hp = 60;
    private static final double ratiodamage = 1.2;
    private static final double money = 50;
    private static final double xp = 0;
    private static final String type = "Samurai";
    private static final int level = 1;


    public Samurai(String name) {
        super(name,hp,ratiodamage,money,xp,type,level);
    }

}
