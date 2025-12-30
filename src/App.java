import controller.*;
import java.time.LocalDate;
import java.util.Scanner;
import model.*;
import persistence.*;

public class App {
    private static Scanner scanner = new Scanner(System.in);
    private static HackathonController hackathonController;
    private static EquipeController equipeController;
    private static EtudiantController etudiantController;
    private static Hackathon hackathon;

    public static void main(String[] args) {
        
        testPartie1();
        
        menuInteractif();
    }

    private static void testPartie1() {
        System.out.println("=== Test Partie 1 ===");
        
        Hackathon hackathonTest = new Hackathon(
            "AI4Morocco 2023",
            LocalDate.of(2023, 12, 25),
            Ville.TAROUDANT
        );

        Equipe equipe1 = new Equipe("Équipe EST");
        Equipe equipe2 = new Equipe("Équipe FST");
        Equipe equipe3 = new Equipe("Équipe ENSA");

        hackathonTest.addEquipe(equipe1);
        hackathonTest.addEquipe(equipe2);
        hackathonTest.addEquipe(equipe3);

        Etudiant etudiant1 = new Etudiant("Mohamed", "Id Baha", "1400002354");
        Etudiant etudiant2 = new Etudiant("Ahmed", "Zitouni", "1400002355");
        Etudiant etudiant3 = new Etudiant("Hassan", "Anab", "1400002356");
        
        equipe1.ajouterEtudiant(etudiant1);
        equipe1.ajouterEtudiant(etudiant2);
        equipe1.ajouterEtudiant(etudiant3);

        hackathonTest.afficherInfos();

        HackathonDataSaver.saveHackathonData(hackathonTest, "hackathon.csv");
        HackathonDataSaver.saveEquipesData(hackathonTest.getEquipes(), "equipes.csv");
        HackathonDataSaver.saveEtudiantsData(hackathonTest.getEquipes(), "etudiants.csv");
        
        System.out.println("\nDonnées sauvegardées dans les fichiers CSV.");
    }

    private static void menuInteractif() {
        hackathonController = new HackathonController(scanner);
        equipeController = new EquipeController(scanner);
        
        hackathon = new Hackathon("Default", LocalDate.now(), Ville.Rabat);
        etudiantController = new EtudiantController(scanner, hackathon);

        boolean quitter = false;
        while (!quitter) {
            System.out.println("\n=== Menu Principal ===");
            System.out.println("1. Gérer Hackathon");
            System.out.println("2. Gérer Équipes");
            System.out.println("3. Gérer Étudiants");
            System.out.println("4. Quitter");

            System.out.print("Choisissez une option: ");
            int choix = scanner.nextInt();
            scanner.nextLine(); 

            switch (choix) {
                case 1:
                    hackathonController.afficherMenu();
                    break;
                case 2:
                    equipeController.afficherMenu();
                    break;
                case 3:
                    etudiantController.afficherMenu();
                    break;
                case 4:
                    quitter = true;
                    break;
                default:
                    System.out.println("Option non valide, veuillez réessayer.");
            }
        }
        scanner.close();
        System.out.println("Programme terminé.");
    }
}