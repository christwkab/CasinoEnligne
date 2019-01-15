/**
 *
 */
package jeu;

import joueur.Joueur;

/**
 * @ W.Christian KABORE
 *
 */
public class Jeu {

    /**
     *
     */
    private String nom;
    private Joueur leJoueur;

    // Constructeur sans argument
    public Jeu() {
        this("Age oft the Gods");
    }

    // Constructeur avec 1 argument
    public Jeu(String nom) {
        this.nom = nom;
    }

    // Constructeur par copie
    public Jeu(Jeu unAutre) {
        // this(unAutre.nom);
        this.nom = unAutre.nom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    // Methodes utilitaires
    public int resultat() {

        return (int) (2 * Math.random());
    }

    // Methode calcul le gains et retour 1(gagnant) e 0(perdant)
    public int calculerGain(int mise) {
        int gains;
        if (this.resultat() == 1) {
            gains = mise * 2;

        } else {
            gains = -1 * mise;
        }

        return gains;//this.resultat() == 1 ? mise * 2 : -1 * mise;

    }

    // Methgode equals pour comparer le jeux
    public boolean equals(Jeu autre) {

        // return this == autre || this.nom == autre.nom;
        boolean egales = true;

        if (!this.nom.equals(autre.nom)) {
            egales = false;
        } else {
            egales = true;
        }

        return egales;
    }

    public String toString() {
        return "Bienvenue dans le  jeu de  " + this.nom + ".  Les  règles du jeu sont les suivants :\n"
                + "Vous jouez un tour et le system determine si vous avez gagné " + "ou perdu .\n"
                + " -Si vous gagnez le tour, votre capital est augmenté du double de votre mise .\n"
                + " -Autrement, vous avez perdu, et votre mise est deduite de votre capital  .\n";
    }

}
