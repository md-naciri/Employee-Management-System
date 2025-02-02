package gestion;

public class Employe {
    private int id;
    private String nom;
    private String poste;
    private double salaire;

    //  Constructeur sans paramètre qui initialise les attributs avec des valeurs par défaut
    public Employe(){}

    //  Constructeur qui initialise tous les attributs de l'employé avec les valeurs fournies
    public Employe(int id, String nom, String poste, double salaire) {
        this.id = id;
        this.nom = nom;
        this.poste = poste;
        this.salaire = salaire;
    }

    //  Méthodes permettant d'accéder et de modifier les attributs privés de l'employé
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    public double getSalaire() {
        return salaire;
    }

    public void setSalaire(double salaire) {
        this.salaire = salaire;
    }

    //  Retourne une chaîne de caractères représentant les informations complètes de l'employé
    @Override
    public String toString() {
        return "Employe{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", poste='" + poste + '\'' +
                ", salaire=" + salaire +
                '}';
    }

    //  Méthode statique pour comparer deux employés en fonction de leur salaire
    public static int compareParSalaire(Employe e1, Employe e2) {
        return Double.compare(e1.getSalaire(), e2.getSalaire());
    }

}
