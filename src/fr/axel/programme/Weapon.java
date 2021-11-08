package fr.axel.programme;

import java.util.ArrayList;

public class Weapon {
    protected String name;
    protected double damage;
    protected double price;


    public Weapon(String name, double damage, double price) {
        this.name = name;
        this.damage = damage;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getDamage() {
        return damage;
    }

    public double getPrice() {
        return price;
    }

}
