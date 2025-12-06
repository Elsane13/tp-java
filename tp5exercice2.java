import java.util.Scanner;

public class Location {
    // Constantes pour les catégories
    public static final char ECONOMIQUE = 'E';
    public static final char CONFORT = 'C';
    public static final char LUXE = 'L';
    
    // Attributs
    private char categorie;
    private int duree; // en jours
    private int kmParcourus;
    
    /**
     * Constructeur par défaut
     */
    public Location() {
        this.categorie = ECONOMIQUE;
        this.duree = 1;
        this.kmParcourus = 0;
    }
    
    /**
     * Constructeur avec paramètres
     * @param categorie la catégorie du véhicule (E, C ou L)
     * @param duree la durée de location en jours (max 30)
     * @param kmParcourus le nombre de kilomètres parcourus
     */
    public Location(char categorie, int duree, int kmParcourus) {
        setCategorie(categorie);
        setDuree(duree);
        setKmParcourus(kmParcourus);
    }
    
    // Getters et Setters avec validation
    public char getCategorie() {
        return categorie;
    }
    
    public void setCategorie(char categorie) {
        categorie = Character.toUpperCase(categorie);
        if (categorie == ECONOMIQUE || categorie == CONFORT || categorie == LUXE) {
            this.categorie = categorie;
        } else {
            this.categorie = ECONOMIQUE; // Valeur par défaut si catégorie invalide
        }
    }
    
    public int getDuree() {
        return duree;
    }
    
    public void setDuree(int duree) {
        if (duree > 0 && duree <= 30) {
            this.duree = duree;
        } else if (duree > 30) {
            this.duree = 30; // On limite à 30 jours
        } else {
            this.duree = 1; // Valeur par défaut
        }
    }
    
    public int getKmParcourus() {
        return kmParcourus;
    }
    
    public void setKmParcourus(int kmParcourus) {
        this.kmParcourus = Math.max(0, kmParcourus); // Pas de valeurs négatives
    }
    
    /**
     * Calcule le prix journalier selon la catégorie
     * @return le prix journalier en euros
     */
    public double montantJour() {
        switch (categorie) {
            case CONFORT:
                return 50.0;
            case LUXE:
                return 80.0;
            case ECONOMIQUE:
            default:
                return 30.0;
        }
    }
    
    /**
     * Calcule le montant de base de la location
     * @return le montant total sans les km supplémentaires
     */
    public double montantLocation() {
        return montantJour() * duree;
    }
    
    /**
     * Calcule le nombre de kilomètres supplémentaires
     * @return le nombre de km dépassant le forfait
     */
    public int kmSupplementaire() {
        int kmInclus = 0;
        
        // Calcul des km inclus selon la durée
        int semaines = duree / 7;
        int joursRestants = duree % 7;
        
        kmInclus += semaines * 1000; // 1000 km par semaine complète
        kmInclus += joursRestants * 100; // 100 km par jour restant
        
        // Pour une location de 30 jours, forfait spécial
        if (duree == 30) {
            kmInclus = 5000;
        }
        
        return Math.max(0, kmParcourus - kmInclus);
    }
    
    /**
     * Calcule le coût des kilomètres supplémentaires
     * @return le montant des km supplémentaires en euros
     */
    public double pxKmSupplementaire() {
        return kmSupplementaire() * 0.5; // 0.5€ par km supplémentaire
    }
    
    /**
     * Calcule le montant total de la location
     * @return le montant total en euros
     */
    public double mtTotal() {
        return montantLocation() + pxKmSupplementaire();
    }
    
    @Override
    public String toString() {
        String categorieStr = "";
        switch (categorie) {
            case ECONOMIQUE: categorieStr = "Economique"; break;
            case CONFORT: categorieStr = "Confort"; break;
            case LUXE: categorieStr = "Luxe"; break;
        }
        
        return String.format("""
                Catégorie: %s
                Durée: %d jour(s)
                Kilométrage effectué: %d km
                Montant de base: %.2f €
                Kilomètres supplémentaires: %d km (%.2f €)
                Montant total: %.2f €""",
                categorieStr, duree, kmParcourus, montantLocation(),
                kmSupplementaire(), pxKmSupplementaire(), mtTotal());
    }
    
    /**
     * Méthode principale pour tester la classe
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== Calcul du coût de location ===\n");
        
        // Saisie des informations
        System.out.print("Catégorie de véhicule (E=Economique, C=Confort, L=Luxe) : ");
        char categorie = scanner.next().toUpperCase().charAt(0);
        
        System.out.print("Durée de location (en jours, max 30) : ");
        int duree = scanner.nextInt();
        
        System.out.print("Nombre de kilomètres parcourus : ");
        int km = scanner.nextInt();
        
        // Création de l'objet Location
        Location location = new Location(categorie, duree, km);
        
        // Affichage du détail
        System.out.println("\n=== Détail de la location ===");
        System.out.println(location);
        
        scanner.close();
    }
}
