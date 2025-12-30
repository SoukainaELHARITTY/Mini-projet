package model;

public class Etudiant extends Personne {
    private String matricule;
    private Universite universite;
    private Equipe equipe;

    public Etudiant(String nom, String prenom, String matricule) {
        super(nom, prenom, "", "");
        this.matricule = matricule;
    }

    // Getters and Setters
    public String getMatricule() { return matricule; }
    public void setMatricule(String matricule) { this.matricule = matricule; }
    
    public Universite getUniversite() { return universite; }
    public void setUniversite(Universite universite) { this.universite = universite; }
    
    public Equipe getEquipe() { return equipe; }
    public void setEquipe(Equipe equipe) { this.equipe = equipe; }
}
