package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Hackathon {
    private String nom;
    private LocalDate date;
    private Ville ville;
    private List<Equipe> equipes = new ArrayList<>();

    public Hackathon(String nom, LocalDate date, Ville ville) {
        this.nom = nom;
        this.date = date;
        this.ville = ville;
    }

    public void addEquipe(Equipe equipe) {
        equipes.add(equipe);
        equipe.setHackathon(this);
    }

    public void removeEquipe(String nomEquipe) {
        equipes.removeIf(e -> e.getNom().equals(nomEquipe));
    }

    public void afficherInfos() {
        System.out.println("=== Informations du Hackathon ===");
        System.out.println("Nom: " + nom);
        System.out.println("Date: " + date);
        System.out.println("Ville: " + ville);
        System.out.println("Nombre d'équipes: " + equipes.size());
        
        for (Equipe equipe : equipes) {
            System.out.println("\nÉquipe: " + equipe.getNom());
            System.out.println("Membres:");
            for (Etudiant etudiant : equipe.getEtudiants()) {
                System.out.println("  - " + etudiant.getPrenom() + " " + etudiant.getNom());
            }
        }
    }

    // Getters and Setters
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    
    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }
    
    public Ville getVille() { return ville; }
    public void setVille(Ville ville) { this.ville = ville; }
    
    public List<Equipe> getEquipes() { return equipes; }
}