package fr.axel.programme;

import java.util.ArrayList;

class Player {

     protected String name;
     protected double hp;
     protected double ratiodamage;
     protected double money;
     protected double xp;
     protected String type;
     protected int level;
     protected ArrayList<Weapon> AllWeapon = new ArrayList<Weapon>();

     public Player(String name, double hp, double ratiodamage, double money, double xp, String type, int level) {
         this.name = name;
         this.hp = hp;
         this.ratiodamage = ratiodamage;
         this.money = money;
         this.xp = xp;
         this.type = type;
         this.level = level;
     }




     public String getName() {
         return name;
     }

     public double getHp() {
         return hp;
     }

     public double getRatiodamage() {
         return ratiodamage;
     }

     public double getMoney() {
         return money;
     }

     public double getXp() {
         return xp;
     }

     public String getType() {
         return type;
     }

     public int getLevel() {
         return level;
     }


     // Level Up d'HP
     public void levelUp() {
         level++;
         ratiodamage *= 1.5;
         hp *= 1.2;
         System.out.println("Bravo, vous venez de passez au niveau suivant, vous êtes désormais Level : " + level + "");
     }

     // Perte d'HP
     public void PlayerLoseHp(double damage) {
         hp = hp - damage;
     }

     public void PlayerWinFight(double xpMonstre, double moneyMonstre ){
         xp = xp + xpMonstre;
         money = money+moneyMonstre;
         hp=+10*ratiodamage;
     }


     //Présentation
     public String toString() {
         return "Votre Personnage est donc un " + type + " qui s'appelle " + name + " et qui possède les caractèristiques suivantes : --- Multiplicateur de dégats = " + ratiodamage + " --- Points de vie = " + hp + "---" + "Level : " + level + "\n Vous possèdez actuellement = " + xp + "XP" + " et " + money + " gold";
     }

     public void levelGrade(){
         if (xp >= 20 ){
             levelUp();
         }else if(xp >= 45){
             levelUp();
         }else if(xp >= 70){
             levelUp();
         }else if(xp >= 120){
             levelUp();
         }else if(xp >= 180){
             levelUp();
         }
     }

     public void achatWeapon(double priceWeapon){
         money = money - priceWeapon;
     }

     public ArrayList<Weapon> getAllWeapon(){
         return getAllWeapon();
     }

 }
