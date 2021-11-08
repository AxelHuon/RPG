package fr.axel.programme;

import java.util.Scanner;

public class Map {
    private char map[][] = {
            {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', 'x', '-'},
            {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '.', '-'},
            {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '.', '-'},
            {'-', '-', '-', 'G', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '.', '-'},
            {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-', 'D', '-', '-', '-', '.', '-'},
            {'-', '-', '-', '-', '-', '-', '-', 'G', '-', '-', '-', '-', '-', '-', '.', '-'},
            {'-', '-', '-', '-', '-', '-', '-', '.', '.', '.', '.', '.', '.', '.', '.', '-'},
            {'-', '-', '-', '-', '-', '.', '-', '.', '-', '-', '-', '-', '-', '-', '-', '-'},
            {'-', 'D', '-', '-', '-', '.', '-', '.', '.', '-', '-', '-', '-', '-', '-', '-'},
            {'-', '.', '.', '.', '.', '.', '.', '.', '-', '-', '-', '-', '-', '-', '-', '-'},
            {'-', '.', '.', 'D', '.', '.', '.', '.', '-', '-', '-', '-', '-', '-', '-', '-'},
            {'-', '.', '.', '-', '.', '.', '*', '.', '.', '-', '-', '-', '-', '-', '-', '-'},
            {'-', '.', '.', '-', '.', '.', '.', '.', '.', '-', '-', '-', '-', '-', '-', '-'},
            {'-', '.', '.', '-', '.', '.', '.', '.', '.', '-', '-', '-', '-', '-', '-', '-'},
            {'-', '.', '.', '-', '.', 'G', '.', '.', '.', 'D', '-', '-', '-', '-', '-', '-'},
            {'-', '.', '.', '.', '.', '.', '.', '.', '.', '-', '-', '-', '-', '-', '-', '-'},
            {'-', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '-', '-', '-'},
            {'-', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '-', '-', '-'},
            {'-', '.', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'}};

    private int x, y;
    private Player p1;
    private Weapon weaponPlayer;

    Map(int x, int y , Player p1, Weapon weaponPlayer) {

        this.x = x;
        this.y = y;
        this.p1 = p1;
        this.weaponPlayer = weaponPlayer;
        Scanner keyboard = new Scanner(System.in);
        this.map[x][y] = 'J';
        this.afficheMap();
        System.out.print("Rejoignez la sortie symbolisé par un X \n");
        System.out.print("Evitez un maxium les Gobelins et les Dragon symbolisé par des D et des G \n");
        while (this.map[x][y] != 'x' || p1.getHp() != 0 ) {
            System.out.print("Ou voulez vous allez ? \n");
            System.out.println("z\t Avancer  ? ");
            System.out.println("s\t Reculer ?");
            System.out.println("d\t Droite  ?");
            System.out.println("q\t Gauche ?");
            String key = keyboard.nextLine();
            switch (key) {
                case "z":
                    this.moveUp();
                    break;
                case "s":
                    this.moveDown();
                    break;
                case "q":
                    this.moveLeft();
                    break;
                case "d":
                    this.moveRight();
                    break;

            }
            this.afficheMap();
        }
    }

    private void afficheMap() {
        for (char[] chars : map) {
            System.out.println(chars);
        }
    }


    private void moveUp() {
        if (this.x != 0 && this.map[this.x-1][this.y] != '-' ) {
            char c= map[x][y];
            map[x][y] = '.';
            this.x -= 1;
            this.checkMap();
            map[this.x][this.y] = c;
        }else {
            System.out.println("vous ne pouver pas plus monter");

        }
    }

    private void moveRight() {
        if (this.y != 15 && this.map[this.x][this.y+1] != '-' ) {
            char c= map[x][y];
            map[x][y] = '.';
            this.y += 1;
            this.checkMap();
            map[this.x][this.y] = c;
        }else {
            System.out.println("vous ne pouver pas plus a droite");

        }
    }

    private void moveLeft() {
        if (this.y != 0 && this.map[this.x][this.y-1] != '-' ) {
            char c= map[x][y];
            map[x][y] = '.';
            this.y -= 1;
            this.checkMap();
            map[this.x][this.y] = c;
        }else {
            System.out.println("vous ne pouvez pas a gauche");

        }
    }
    private void moveDown() {
        if(this.x != 18 && this.map[this.x+1][this.y] != '-' ) {
            char c= map[x][y];
            map[x][y] = '.';
            this.x += 1;
            this.checkMap();
            map[this.x][this.y] = c;
        }else {
            System.out.println("vous ne pouvez pas a descendre");

        }

    }

    public void checkMap() {
        p1.levelGrade();
        switch (map[x][y]) {
            case 'D':
                System.out.println("Voici un Dragon");
                Scanner in = new Scanner(System.in);
                Dragon d1 =  new Dragon();
                System.out.print("Que voulez vous faire ? \n");
                System.out.println("1\t Fuire ? ");
                System.out.println("2\t Combattre ?");
                System.out.println("Rentrez votre choix : ");
                int choice=in.nextInt();
                if (choice == 1){
                    System.out.println("Vous avez fuis ! ");
                }else if (choice == 2){
                    while (p1.getHp() == 0 || d1.getHp() == 0){
                        p1.PlayerLoseHp(d1.getDamage());
                    }
                    if(p1.getHp() == 0 ){
                        System.out.println("Vous êtes mort vous avez perdu !");
                    }else if(d1.getHp() == 0){
                        System.out.println("Vous avez battu le Dragon, Bravo");
                        p1.PlayerWinFight(d1.getXp(), d1.getMoney());
                        System.out.println("Il vous reste " + p1.getHp() + "hp et vous avez désormais " + p1.getMoney() + "\n");
                        System.out.println("Vous pouvez vous rendre dès que vous le voulez chez le marchant sur la MAP singalisé par une * pour échangez votre arme actuelle ");
                    }
                }
                break;
                case 'x':
                    System.out.println("Bravo vous avez fini la partie !");
                break;
            case 'G':
                System.out.println("Voici un Gobelin");
                Scanner in2 = new Scanner(System.in);
                Gobelin g1 =  new Gobelin();
                System.out.print("Que voulez vous faire ? \n");
                System.out.println("1\t Fuire ? ");
                System.out.println("2\t Combattre ?");
                System.out.println("Rentrez votre choix : ");
                int choice2=in2.nextInt();
                if (choice2 == 1){
                    this.moveDown();
                    System.out.println("Vous avez fuis ! ");
                }else if (choice2 == 2){
                    while (p1.getHp() == 0 || g1.getHp() == 0){
                        p1.PlayerLoseHp(g1.getDamage());
                    }
                    if(p1.getHp() == 0 ){
                        System.out.println("Vous êtes mort vous avez perdu !");
                    }else if(g1.getHp() == 0){
                        System.out.println("Vous avez battu le Dragon, Bravo");
                        p1.PlayerWinFight(g1.getXp(), g1.getMoney());
                        System.out.println("Il vous reste " + p1.getHp() + "hp et vous avez désormais " + p1.getMoney() + "\n");
                        System.out.println("Vous pouvez vous rendre dès que vous le voulez chez le marchant sur la MAP singalisé par une * pour échangez votre arme actuelle ");
                    }
                }
                break;
            case '*':
                System.out.println("Voici un shop");
                new Shop();
                System.out.println("Bienvenue dans le shop,Voulez vous changez d'arme ? ");
                Shop sh = new Shop();
                Scanner weapon = new Scanner(System.in);

                Weapon vitrineW1 = new Katana();
                Weapon vitrineW2 = new Nunchaku();
                Weapon vitrineW3 = new Ax();
                Weapon vitrineW4 = new Sword();
                Weapon weaponPlayer = null;
                System.out.println("il vous reste donc maintenant " + p1.getMoney() + " gold");

                Weapon w1 = sh.getShopWeapons();
                int choiceWeapon=weapon.nextInt();
                if (choiceWeapon == 1 && p1.getMoney() > vitrineW1.getPrice()){
                    weaponPlayer = new Katana();
                    System.out.println("Vous avez donc choisis l'arme : "  + weaponPlayer.getName());
                    p1.achatWeapon(weaponPlayer.getPrice());
                    System.out.println("il vous reste donc maintenant " + p1.getMoney() + " gold");
                }else if (choiceWeapon == 2 && p1.getMoney() > vitrineW2.getPrice() ){
                    weaponPlayer = new Nunchaku();
                    System.out.println(" Vous avez donc choisis l'arme : "  + weaponPlayer.getName());
                    p1.achatWeapon(weaponPlayer.getPrice());
                    System.out.println("il vous reste donc maintenant " + p1.getMoney() + " gold");

                }else if (choiceWeapon == 3 && p1.getMoney() > vitrineW3.getPrice()){
                    weaponPlayer = new Sword();
                    System.out.println("Vous avez donc choisis l'arme : "  + weaponPlayer.getName());
                    p1.achatWeapon(weaponPlayer.getPrice());
                    System.out.println("il vous reste donc maintenant " + p1.getMoney() + " gold");

                }else if (choiceWeapon == 4 && p1.getMoney() > vitrineW4.getPrice()){
                    weaponPlayer = new Ax();
                    System.out.println("Vous avez donc choisis l'arme : "  + weaponPlayer.getName());
                    p1.achatWeapon(weaponPlayer.getPrice());
                    System.out.println("il vous reste donc maintenant " + p1.getMoney() + " gold");
                }else{
                    System.out.println("Vous n'avez pas assez de gold");
                }
                break;
            case '.':
                System.out.println("Continue t'as route !");
                break;
        }
    }


}