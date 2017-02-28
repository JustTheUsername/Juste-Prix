/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package justeprix;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author Benjamin
 */
public class JustePrix {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int choiceNewGame;
        boolean newGame = true; // initie newGame à true 

        Scanner inputAnswer = new Scanner(System.in);

        //*******************Initialisation de la partie**********************//
        while (newGame == true) {
            // deux méthodes pour generer un nombre aléatoire
            // int mysteryNumber=ThreadLocalRandom.current().nextInt(1,101);    
            int minimum = -50;
            int maximum = 50;
            //assigne à "mysteryNumber" une valeur aléatoire de range [minimum-maximum+1]
            int mysteryNumber = minimum + (int) (Math.random() * maximum + 1);

            int i = 10;//nombre d'essaie du joueur

            System.out.println("Essayer de deviner le nombre mystère (petit indice il est compris entre" + minimum + " et " + maximum + " )");

            //*************************Algorithme du jeu**************************//
            //utilisation de do/while car on entame le jeu sans perdre de vie evidemment
            do {

                int answerNumber;
                //Blindage  pour filtrer les int
                while (!inputAnswer.hasNextInt()) {

                    System.out.println("On t'a demandé un nombre sombre idiot");
                    inputAnswer.nextLine();
                }
                // si c'est bien un int le met dans answerNumber
                answerNumber = inputAnswer.nextInt();

                // verification si le nombre n'est pas hors limites
                if (answerNumber < minimum || answerNumber > maximum) {

                    System.out.println("Saisie est incorect on t'a dit entre " + minimum + " et " + maximum + " !");
                    inputAnswer.nextLine();
                } //**************condition générale du jeu*********************//
                else {

                    //*******************condition de victoire********************//
                    if (answerNumber == mysteryNumber) {

                        /*donne au joueur son "score"
 11-i car on commence avec i=10newGame ==false car la partie est terminée */
                        System.out.println("Féliciation ! vous avez trouvé le nombre mystère en " + (11 - i) + " coups");
                        newGame = false;
                        i=-1; // on sort de la boucle 

                    } else if (answerNumber < mysteryNumber) {

                        System.out.println("C'est plus grand");
                        i--;
                    } else {
                        System.out.println("C'est plus petit");
                        i--;
                    }
                }

                //si le joueur n'a plus d'essais
                if (i == 0) {
                    System.out.println("Vous avez perdu le nombre mystère était" + mysteryNumber);
                    newGame = false;
                }

            } while (i > 0);

            //*****************************************************Partie terminée******************************************************//
            //quand newGame == false ( game over) on demande au joueur si il veut recommencer une partie
            System.out.println("Voulez-vous jouer à nouveau ? \n1) oui\n2) non");

            //filtre les int
            while (!inputAnswer.hasNextInt()) {

                System.out.println("On t'a demandé un nombre sombre idiot");
                inputAnswer.nextLine();
            }
            choiceNewGame = inputAnswer.nextInt();
            //filtre le choix entré 
            while (choiceNewGame < 1 || choiceNewGame > 2) {
                System.out.println("Saisie incorrecte");
                inputAnswer.nextLine();

                //filtre les int
                while (!inputAnswer.hasNextInt()) {
                    System.out.println("On t'a demandé un nombre sombre idiot");
                    inputAnswer.nextLine();
                }
                choiceNewGame = inputAnswer.nextInt();
            }

            //recommence une partie
            if (choiceNewGame == 1) {
                newGame = true;
            } //***********************Sortie du programme**********************//
            else if (choiceNewGame == 2) {
                System.out.println("A bientôt");
            }
        }

    }
}