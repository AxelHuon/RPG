package fr.axel.programme;

import java.util.ArrayList;
import java.util.Scanner;

public class Shop {
    public ArrayList<Weapon> Shop;
    public Shop() {
        this.Shop = new ArrayList<Weapon>();
        Shop.add(new Katana());
        Shop.add(new Nunchaku());
        Shop.add(new Sword());
        Shop.add(new Ax());
    }

    public Weapon getShopWeapons(){
        System.out.println("Voici le shop du RPG,vous y retrouverez les armes disponibles à l'achat");
        int choice = 1;
        for(Weapon w :Shop) {
            int i = choice++;
            System.out.println(i+"\t"+ w.getName() + " " + w.getDamage() +" "+ w.getPrice());
        }
        System.out.println("Veuillez rentrez votre choix  : ");
        return null;
    }
}




