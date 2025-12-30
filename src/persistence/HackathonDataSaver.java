package persistence;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import model.Equipe;
import model.Etudiant;
import model.Hackathon;

public class HackathonDataSaver {
    
    public static void saveHackathonData(Hackathon hackathon, String hackathonFilePath) {
        try (FileWriter csvWriter = new FileWriter(hackathonFilePath)) {
            csvWriter.append("Nom,Date,Lieu\n");
            csvWriter.append(hackathon.getNom()).append(",")
                    .append(hackathon.getDate().toString()).append(",")
                    .append(hackathon.getVille().toString()).append("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveEquipesData(List<Equipe> equipes, String equipesFilePath) {
        try (FileWriter csvWriter = new FileWriter(equipesFilePath)) {
            csvWriter.append("Nom Equipe,Nom Hackathon\n");
            for (Equipe equipe : equipes) {
                String nomHackathon = equipe.getHackathon() != null ? 
                    equipe.getHackathon().getNom() : "Inconnu";
                csvWriter.append(equipe.getNom()).append(",")
                        .append(nomHackathon).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveEtudiantsData(List<Equipe> equipes, String etudiantsFilePath) {
        try (FileWriter csvWriter = new FileWriter(etudiantsFilePath)) {
            csvWriter.append("Nom Etudiant,Prénom Etudiant,Matricule,Equipe\n");
            for (Equipe equipe : equipes) {
                for (Etudiant etudiant : equipe.getEtudiants()) {
                    csvWriter.append(etudiant.getNom()).append(",")
                            .append(etudiant.getPrenom()).append(",")
                            .append(etudiant.getMatricule()).append(",")
                            .append(equipe.getNom()).append("\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}