package controller;

import java.time.LocalDate;
import java.util.Scanner;
import model.Equipe;
import model.Hackathon;
import model.Ville;

public class HackathonController {
    private Scanner scanner;
    private Hackathon hackathon;

    public HackathonController(Scanner scanner) {
        this.scanner = scanner;
    }

    public void afficherMenu() {
        boolean retour = false;
        while (!retour) {
            System.out.println("\n=== Sous-Menu Hackathon ===");
            System.out.println("1. Créer un hackathon");
            System.out.println("2. Afficher les détails du hackathon");
            System.out.println("3. Ajouter une équipe");
            System.out.println("4. Supprimer une équipe");
            System.out.println("5. Retour");

            System.out.print("Choisissez une option: ");
            int choix = scanner.nextInt();
            scanner.nextLine(); 

            switch (choix) {
                case 1:
                    creerHackathon();
                    break;
                case 2:
                    afficherDetailsHackathon();
                    break;
                case 3:
                    ajouterEquipe();
                    break;
                case 4:
                    supprimerEquipe();
                    break;
                case 5:
                    retour = true;
                    break;
                default:
                    System.out.println("Option non valide, veuillez réessayer.");
            }
        }
    }

    private void creerHackathon() {
        System.out.print("Entrez le nom du hackathon: ");
        String nom = scanner.nextLine();
        
        System.out.print("Entrez la date du hackathon (format: YYYY-MM-DD): ");
        String dateStr = scanner.nextLine();
        LocalDate date = LocalDate.parse(dateStr);
        
        System.out.print("Entrez la ville du hackathon: ");
        String villeStr = scanner.nextLine();
        Ville ville = Ville.valueOf(villeStr.toUpperCase());
        
        hackathon = new Hackathon(nom, date, ville);
        System.out.println("Hackathon '" + nom + "' créé avec succès !");
    }

    private void afficherDetailsHackathon() {
        if (hackathon != null) {
            hackathon.afficherInfos();
        } else {
            System.out.println("Aucun hackathon n'est actuellement créé.");
        }
    }

    private void ajouterEquipe() {
        if (hackathon != null) {
            System.out.print("Entrez le nom de la nouvelle équipe: ");
            String nomEquipe = scanner.nextLine();
            Equipe nouvelleEquipe = new Equipe(nomEquipe);
            hackathon.addEquipe(nouvelleEquipe);
            System.out.println("Équipe '" + nomEquipe + "' ajoutée avec succès au hackathon.");
        } else {
            System.out.println("Veuillez d'abord créer un hackathon.");
        }
    }

    private void supprimerEquipe() {
        if (hackathon != null) {
            System.out.print("Entrez le nom de l'équipe à supprimer: ");
            String nomEquipe = scanner.nextLine();
            hackathon.removeEquipe(nomEquipe);
            System.out.println("Équipe '" + nomEquipe + "' supprimée avec succès du hackathon.");
        } else {
            System.out.println("Veuillez d'abord créer un hackathon.");
        }
    }
}