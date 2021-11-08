package fr.axel.programme;


import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        System.out.println("Bienvenue dans le jeu RPG d'Axel Huon. \nLa partie va commencer.");
        //CREATION DU PERSONNAGE
        //Nom du personnage
        Scanner user_input = new Scanner( System.in );
        System.out.print("Entrez le nom de votre personnage : \n");
        String name_player;
        name_player = user_input.next( );
        Scanner in = new Scanner(System.in);
        //Menu de choix de classe
        System.out.print("Veuillez choisir le type de personnage que vous voulez jouez \n");
        System.out.println("1\t Samurai");
        System.out.println("2\t Ninja");
        System.out.println("3\t Chevalier");
        System.out.println("4\t Viking");
        System.out.println("Rentrez votre choix : ");
        int choice=in.nextInt();
        Player p1 =null;
        if (choice == 1){
            p1 = new Samurai(name_player);
        }else if (choice == 2){
            p1 = new Ninja(name_player);
        }else if (choice == 3){
            p1 = new Chevalier(name_player);
        }else if (choice == 4){
            p1 = new Viking(name_player);
        }else{
            System.out.println("Vous avez choisit une mauvaise réponse, relancez le jeu");
        }

        //Method de level up
        p1.levelGrade();



        System.out.println("Bienvenue dans le shop, veuillez choisir une arme pour commencer a vous combattre");
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

        Map map1 = new Map(18,1, p1, weaponPlayer);

    }

}







