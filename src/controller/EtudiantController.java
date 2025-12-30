package controller;

import java.util.Scanner;
import model.Etudiant;
import model.Hackathon;

public class EtudiantController {
    private Scanner scanner;
    private Hackathon hackathon;

    public EtudiantController(Scanner scanner, Hackathon hackathon) {
        this.scanner = scanner;
        this.hackathon = hackathon;
    }

    public void afficherMenu() {
        boolean retour = false;
        while (!retour) {
            System.out.println("\n=== Sous-Menu Étudiant ===");
            System.out.println("1. Créer un étudiant");
            System.out.println("2. Assigner un étudiant à une équipe");
            System.out.println("3. Mettre à jour les détails d'un étudiant");
            System.out.println("4. Afficher les informations d'un étudiant");
            System.out.println("5. Retour");

            System.out.print("Choisissez une option: ");
            int choix = scanner.nextInt();
            scanner.nextLine(); 

            switch (choix) {
                case 1:
                    creerEtudiant();
                    break;
                case 2:
                    assignerEtudiantAEquipe();
                    break;
                case 3:
                    mettreAJourEtudiant();
                    break;
                case 4:
                    afficherInformationsEtudiant();
                    break;
                case 5:
                    retour = true;
                    break;
                default:
                    System.out.println("Option non valide, veuillez réessayer.");
            }
        }
    }

    private void creerEtudiant() {
        System.out.print("Entrez le nom de l'étudiant: ");
        String nom = scanner.nextLine();
        
        System.out.print("Entrez le prénom de l'étudiant: ");
        String prenom = scanner.nextLine();
        
        System.out.print("Entrez le matricule de l'étudiant: ");
        String matricule = scanner.nextLine();

        Etudiant etudiant = new Etudiant(nom, prenom, matricule);
        System.out.println("Étudiant '" + nom + " " + prenom + "' créé avec succès.");
    }

    private void assignerEtudiantAEquipe() {
        System.out.println("Fonctionnalité à implémenter...");
    }

    private void mettreAJourEtudiant() {
        System.out.println("Fonctionnalité à implémenter...");
    }

    private void afficherInformationsEtudiant() {
        System.out.println("Fonctionnalité à implémenter...");
    }
}