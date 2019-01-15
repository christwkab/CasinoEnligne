/**
 *
 */
package testCasino;

import casino.Casino;
/**
 * @ W.Christian KABORE
 *
 */
import jeu.*;
import joueur.Joueur;
import casino.*;

public class TestCasino {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        System.out.println("************************Test de la classe Jeu************ ***************\n");
        Jeu leJeu = new Jeu("Black Jack");
        Jeu leJeu1 = new Jeu("Go of the War");

        System.out.println("Avant le setter " + leJeu.getNom() + "\n");

        leJeu.setNom("Jack Bouer");
        System.out.println("Après le setter" + leJeu.getNom() + "\n");

        System.out.println("Le resultat pile pour 1 ou face pour 0 :" + leJeu.resultat() + "\n");
        System.out.println("Calcule du gain du Joueur :" + leJeu.calculerGain(200) + "\n");

        System.out.println("Commparaison  " + leJeu.equals(leJeu1) + "\n");

        System.out.println("************************Test de la classe Casino*******************************************\n");

        Casino Quebec = new Casino("Quebec", 2);
        Casino Longueuil = new Casino("Longueuil", 2);

        System.out.println("-------------Methode aJouter joueurs------------\n");
        Quebec.ajouterJoueur(new Joueur("KABORE", 200, Quebec));
        Quebec.ajouterJoueur(new Joueur("Marie", 300, Quebec));
        Quebec.ajouterJoueur(new Joueur("Franck", 100, Quebec));
        System.out.println(Quebec);

        System.out.println("-------------Methode enlever joueurs------------\n");

        Quebec.enleverJoueur("Marie");
        System.out.println("Liste des joueurs apres suppression .\n" + Quebec);

        System.out.println("-------------Methode jouer------------\n");
       
        System.out.println(Longueuil);

        System.out.println("*******************Test de la classe Joueur*****************************\n");
        Joueur monJoueur = new Joueur("TRAORE", 200, Longueuil);
        Joueur monJoueur1 = new Joueur("Jean", 200, Longueuil);
        Joueur monJoueur2 = new Joueur("Paul", 0, Longueuil);

        System.out.println("-------------Methode Joindre ------------  \n");
        monJoueur.joindreCasino(Longueuil);
        monJoueur1.joindreCasino(Longueuil);
        monJoueur2.joindreCasino(Longueuil);

        System.out.println("-------------Methode Quitter  ------------\n");

        System.out.println(monJoueur.quitterCasino(Longueuil));
        System.out.println(Longueuil);

        System.out.println("-------------Liste des joueurs ------------\n");
        monJoueur.jouer(100);
        System.out.println(Longueuil);

    }

}
