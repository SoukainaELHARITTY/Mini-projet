package model;

import java.util.ArrayList;
import java.util.List;

public class Equipe {
    private String nom;
    private List<Etudiant> etudiants = new ArrayList<>();
    private Hackathon hackathon;

    public Equipe(String nom) {
        this.nom = nom;
    }

    public void ajouterEtudiant(Etudiant etudiant) {
        etudiants.add(etudiant);
        etudiant.setEquipe(this);
    }

    public void retirerEtudiant(Etudiant etudiant) {
        etudiants.remove(etudiant);
        etudiant.setEquipe(null);
    }

    // Getters and Setters
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    
    public List<Etudiant> getEtudiants() { return etudiants; }
    
    public Hackathon getHackathon() { return hackathon; }
    public void setHackathon(Hackathon hackathon) { this.hackathon = hackathon; }
}
