package fr.axel.programme;

public class Monstre {
    protected String name;
    protected double hp;
    protected double damage;
    protected double money;
    protected double xp;

    public Monstre(String name, double hp, double damage, double money, double xp) {
        this.name = name;
        this.hp = hp;
        this.damage = damage;
        this.money = money;
        this.xp = xp;
    }

    public String getName() {
        return name;
    }

    public double getHp() {
        return hp;
    }

    public double getDamage() {
        return damage;
    }

    public double getMoney() {
        return money;
    }

    public double getXp() {
        return xp;
    }

    public void MonstreLoseHp(double damageWeapon, double ratioDamage){

        hp = hp - damageWeapon*ratioDamage;

    }

}
