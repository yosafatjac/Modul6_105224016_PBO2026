package game.game;

public class Main {
    public static void main(String[] args) {

        Hero hero1 = new Hero("Dwi", 2500.0, 120.0);
        HeroStrength hero2 = new HeroStrength("Pradana", 3000.0, 150.0);

        System.out.println("STATUS AWAL");
        System.out.println("Hero 1");
        hero1.display();
        System.out.println("\nHero 2");
        hero2.display();

        System.out.println("\nFase Latihan");
        hero1.berlatih();
        hero2.berlatih();

        System.out.println("\nFase Terkena Serangan");
        hero1.terimaSerangan(50.0);
        hero2.terimaSerangan(50.0); 

        System.out.println("\nStatus Akhir");
        System.out.println("Hero 1");
        hero1.display();
        System.out.println("\nHero 2");
        hero2.display();
    }
}
