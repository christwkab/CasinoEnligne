/**
 *
 */
package casino;

import joueur.Joueur;
import jeu.*;
import java.util.Arrays;

/**
 * @ W.Christian KABORE
 *
 */
public class Casino {

    private String nom;
    private int maxJoueur;
    private Joueur lesJoueurs[];
    private int nbJoueurs;
    private Jeu jeu;

    // Construteur sans arguments
    public Casino() {
        this("Sans nom", 20);
    }

    // Construteur avec deux (02) arguments
    public Casino(String nom, int maxJoueur) {
        this.nom = nom;
        this.maxJoueur = maxJoueur;
        lesJoueurs = new Joueur[maxJoueur];
        this.nbJoueurs = 0;
        this.jeu = new Jeu();
    }

    // Construteur par copie
    public Casino(Casino autre) {
        this(autre.nom, autre.maxJoueur);

        this.lesJoueurs = new Joueur[this.maxJoueur];
        this.nbJoueurs = autre.nbJoueurs;
        this.jeu = autre.jeu;
        for (int i = 0; i < this.nbJoueurs; i++) {
            Joueur aAjouter = new Joueur(autre.lesJoueurs[i]);
            this.lesJoueurs[i] = aAjouter;
        }

    }

    // Les accesseurs et mutateurs
    public String getNom() {
        return nom;
    }

    public Joueur[] getJoueurs() {
        return lesJoueurs;
    }

    public Jeu getJeu() {
        return jeu;
    }

    public int getNbJoueurs() {
        return nbJoueurs;
    }

    public int getMaxJoueur() {
        return maxJoueur;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setJeu(Jeu jeu) {
        this.jeu = jeu;
    }

    public void setNbJoueurs(int nbJoueurs) {
        this.nbJoueurs = nbJoueurs;
    }

    // Ajouter un nouveau joueur
    public boolean ajouterJoueur(Joueur nouveauJoueur) {

        if (nbJoueurs < maxJoueur && nouveauJoueur != null) {
            this.lesJoueurs[nbJoueurs] = nouveauJoueur;
            nbJoueurs++;
            return true;
        } else {

            System.err.println("Il n'y a plus de place disponible dans le casino pour le " + (this.nbJoueurs + 1) + " ème joueurs");
            return false;
        }
    }

    // Rechercher un joueur
    public int chercherJoueur(String joueurCheche) {
        int indexChercher = -1;
        for (int i = 0; i < this.nbJoueurs; i++) {
            if (joueurCheche.equals(lesJoueurs[i].getNom())) {
                indexChercher = i;
                break;
            }
        }
        return indexChercher;
    }

//Enlever un joueur
    public boolean enleverJoueur(String aEnlverer) {
        int positionJoueur = chercherJoueur(aEnlverer);
        if (positionJoueur == -1 && this.lesJoueurs == null) {
            System.out.println("Le joeur n'est pas disponible");
            return false;
        } else {
            this.lesJoueurs[positionJoueur] = this.lesJoueurs[nbJoueurs - 1];
            this.lesJoueurs[nbJoueurs - 1] = null;
            this.nbJoueurs--;
            System.out.println("Le joueur a été enlevé de la liste des joueurs");
            return true;
        }

    }

    //Methode joueur
    public void jouer(int mise, Joueur joueur) {
        if (joueur.getCapital() < mise) {
            System.out.println("Vous n'avez pas assez d'argent pour miser");
        } else {
           joueur.setCapital(joueur.getCapital() - mise);
           joueur.setCapital(joueur.getCapital() + jeu.calculerGain(mise));
        }

    }


    // Methode de comparaison
    public boolean equals(Casino autre) {
        boolean compare = true;

        if (!this.nom.equals(autre.nom)
                || this.maxJoueur != autre.maxJoueur
                || this.nbJoueurs != autre.nbJoueurs
                || (!(this.jeu.getNom()).equals(autre.jeu.getNom()))) {
            compare = false;
        } else {
            for (int i = 0; i < this.nbJoueurs; i++) {
                if (!this.lesJoueurs[i].equals(autre.lesJoueurs[i])) {
                    compare = false;
                    break;
                }
            }
        }

        return compare;
    }

    //Affichage de la liste des joueurs
    public String afficherDetailJoueur() {
        String affiche = "";
        int i = 0;
        if (this.nbJoueurs > 0 && this.lesJoueurs != null) {
            affiche += this.nbJoueurs + " joueur(s) présentement dans le casino " + this.nom + " --:\n";
            while (i < this.nbJoueurs) {
                affiche += this.lesJoueurs[i];
                i++;
            }

        }
        return affiche;
    }

    // Methode ToString
    public String toString() {
        return this.afficherDetailJoueur() + "\n";
    }

}
