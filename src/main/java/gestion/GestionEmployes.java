package gestion;

import java.util.Arrays;
import java.util.Scanner;

public class GestionEmployes {
    private static final int MAX_EMPLOYES = 50;
    private static Employe[] employes = new Employe[MAX_EMPLOYES];
    private static int nombreEmployes = 0;

    //  Affiche le menu principal permettant à l'utilisateur de choisir l'action à effectuer
    public static void printMenu() {
        System.out.println("\n=== Menu Gestion des Employés ===");
        System.out.println("1. Ajouter un employé");
        System.out.println("2. Modifier un employé");
        System.out.println("3. Supprimer un employé");
        System.out.println("4. Afficher tous les employés");
        System.out.println("5. Rechercher un employé");
        System.out.println("6. Calculer la masse salariale");
        System.out.println("7. Trier les employés par salaire");
        System.out.println("8. Quitter");
        System.out.print("Choisissez une option : ");
    }

    //  Ajoute un nouvel employé au tableau si l'espace est disponible
    public static void ajouterEmploye(Employe employe) {
        if (nombreEmployes >= MAX_EMPLOYES) {
            System.out.println("Erreur : La liste des employés est pleine.");
            return;
        }
        employes[nombreEmployes] = employe;
        nombreEmployes++;
        System.out.println("Employé ajouté avec succès !");
    }

    //  Modifie les informations d'un employé existant en fonction de son ID
    public static void modifierEmploye(int id, String nouveauNom, String nouveauPoste, double nouveauSalaire) {
        for (int i = 0; i < nombreEmployes; i++) {
            if (employes[i].getId() == id) {
                employes[i].setNom(nouveauNom);
                employes[i].setPoste(nouveauPoste);
                employes[i].setSalaire(nouveauSalaire);
                System.out.println("Employé modifié avec succès !");
                return;
            }
        }
        System.out.println("Erreur : Aucun employé trouvé avec cet ID.");
    }

    //  Supprime un employé du tableau en utilisant son ID
    public static void supprimerEmploye(int id) {
        for (int i = 0; i < nombreEmployes; i++) {
            if (employes[i].getId() == id) {
                for (int j = i; j < nombreEmployes - 1; j++) {
                    employes[j] = employes[j + 1];
                }
                employes[nombreEmployes - 1] = null;
                nombreEmployes--;
                System.out.println("Employé supprimé avec succès !");
                return;
            }
        }
        System.out.println("Erreur : Aucun employé trouvé avec cet ID.");
    }

    //  Affiche tous les employés présents dans le tableau
    public static void afficherEmployes() {
        if (nombreEmployes == 0) {
            System.out.println("Aucun employé à afficher.");
            return;
        }
        for (int i = 0; i < nombreEmployes; i++) {
            System.out.println(employes[i].toString());
        }
    }

    //  Recherche un employé par son nom ou son poste et affiche ses informations
    public static void rechercherEmploye(String critere) {
        boolean trouvé = false;
        for (int i = 0; i < nombreEmployes; i++) {
            if (employes[i].getNom().contains(critere) || employes[i].getPoste().contains(critere)) {
                System.out.println(employes[i].toString());
                trouvé = true;
            }
        }
        if (!trouvé) {
            System.out.println("Aucun employé trouvé avec ce critère.");
        }
    }

    //  Calcule et affiche la somme totale des salaires des employés
    public static void calculerMasseSalariale() {
        double totalSalarial = 0;
        for (int i = 0; i < nombreEmployes; i++) {
            totalSalarial += employes[i].getSalaire();
        }
        System.out.println("La masse salariale totale est : " + totalSalarial);
    }

    //  Trie les employés par leur salaire (croissant ou décroissant) et affiche la liste triée
    public static void trierEmployesParSalaire(boolean ordreCroissant) {
        if (ordreCroissant) {
            Arrays.sort(employes, 0, nombreEmployes, (e1, e2) -> Double.compare(e1.getSalaire(), e2.getSalaire()));
        } else {
            Arrays.sort(employes, 0, nombreEmployes, (e1, e2) -> Double.compare(e2.getSalaire(), e1.getSalaire()));
        }
        afficherEmployes();
    }

    // Point d'entrée du programme, affiche le menu et appelle les méthodes correspondantes en fonction de l'option choisie
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            printMenu();  // Afficher le menu
            int choix = scanner.nextInt();  // Lire l'option choisie

            switch (choix) {
                case 1:
                    // Ajouter un employé
                    System.out.print("Entrez l'ID : ");
                    int id = scanner.nextInt();
                    scanner.nextLine();  // Pour consommer la ligne vide
                    System.out.print("Entrez le nom : ");
                    String nom = scanner.nextLine();
                    System.out.print("Entrez le poste : ");
                    String poste = scanner.nextLine();
                    System.out.print("Entrez le salaire : ");
                    double salaire = scanner.nextDouble();
                    ajouterEmploye(new Employe(id, nom, poste, salaire));
                    break;

                case 2:
                    // Modifier un employé
                    System.out.print("Entrez l'ID de l'employé à modifier : ");
                    int idModifier = scanner.nextInt();
                    scanner.nextLine();  // Consommer la ligne vide
                    System.out.print("Entrez le nouveau nom : ");
                    String nouveauNom = scanner.nextLine();
                    System.out.print("Entrez le nouveau poste : ");
                    String nouveauPoste = scanner.nextLine();
                    System.out.print("Entrez le nouveau salaire : ");
                    double nouveauSalaire = scanner.nextDouble();
                    modifierEmploye(idModifier, nouveauNom, nouveauPoste, nouveauSalaire);
                    break;

                case 3:
                    // Supprimer un employé
                    System.out.print("Entrez l'ID de l'employé à supprimer : ");
                    int idSupprimer = scanner.nextInt();
                    supprimerEmploye(idSupprimer);
                    break;

                case 4:
                    // Afficher tous les employés
                    afficherEmployes();
                    break;

                case 5:
                    // Rechercher un employé
                    scanner.nextLine();  // Consommer la ligne vide
                    System.out.print("Entrez le critère de recherche (nom ou poste) : ");
                    String critere = scanner.nextLine();
                    rechercherEmploye(critere);
                    break;

                case 6:
                    // Calculer la masse salariale
                    calculerMasseSalariale();
                    break;

                case 7:
                    // Trier les employés par salaire
                    System.out.print("Trier par salaire (true pour croissant, false pour décroissant) : ");
                    boolean ordreCroissant = scanner.nextBoolean();
                    trierEmployesParSalaire(ordreCroissant);
                    break;

                case 8:
                    // Quitter
                    System.out.println("Au revoir !");
                    scanner.close();
                    return;

                default:
                    System.out.println("Option invalide. Veuillez réessayer.");
            }
        }
    }


}
