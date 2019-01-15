/**
 *
 */
package joueur;

import casino.Casino;
import jeu.*;

/**
 * @ W.Christian KABORE
 *
 */
public class Joueur {

    /**
     *
     */
    private String nom;
    public int capital;
    private Casino casino;

    // Constructeur sans argument
    public Joueur() {
    }

    // Constructeur avec deux(02)argument
    public Joueur(String leNom, int leCapital, Casino casino) {
        this.nom = leNom;
        this.capital = leCapital;
        this.casino = null;
    }

    // Constructeur par Copie
    public Joueur(Joueur autre) {
        // this(autre.nom,autre.capital);
        this.nom = autre.nom;
        this.capital = autre.capital;
        this.casino = autre.casino;
    }

    // Acesseurs et Mutateur
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getCapital() {
        return capital;
    }

    public void setCapital(int capital) {
        this.capital = capital;
    }

    public Casino getCasino() {
        return casino;
    }

    // Joindre Casino
     public void joindreCasino(Casino casino) {

        if (this.capital <= 0) {
            System.out.println("Je n'ai pas d'argent :(");
        } else if (this.casino != null) {
            System.out.println("Je ne peux pas être dans deux casinos à la fois!");
        } else if (casino.ajouterJoueur(this)) {
            this.casino = casino;
        }

    }
    // Quitter Casino
    public boolean quitterCasino(Casino casino) {
        boolean quitterAvecSucces = false;

        for (Joueur joueur : casino.getJoueurs()) {
            if (joueur != null && joueur.getNom().equals(nom)) {
                casino.enleverJoueur(this.nom);
                quitterAvecSucces = true;
                System.out.println(" Le joueur " + this.nom + " a quitté le casino");

                break;
            }

        }

        return quitterAvecSucces;

    }

    // Methode jouer 
    
    public void jouer(int mise){
        if(casino != null){
            casino.jouer(mise, this);
        }
    }
    //Methode de comparaison

    public boolean equals(Joueur autre) {
        if (this.nom.equals(autre.nom)
                && this.capital == autre.capital
                && this.casino == autre.casino) {
            return true;
        } else {
            return false;
        }
    }

    // Methode ToString
    public String toString() {

        if (this.casino != null) {
            return "Le joueur, " + this.nom + ", posede un capital de  " + this.capital
                    + " et se trouve dans le casino de  " + this.casino.getNom() + "\n";
        } else {
            return "Le joueur, " + this.nom + ", posede un capital de  " + this.capital;
        }
    }
}
