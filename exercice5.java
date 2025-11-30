import java.util.Scanner;

public class exercice5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== Calcul du montant de la facture ===");
        System.out.print("Entrez la quantité d'articles : ");
        int quantite = scanner.nextInt();
        
        int prixUnitaire;
        
        if (quantite <= 0) {
            System.out.println("Erreur : La quantité doit être supérieure à 0");
            return;
        } else if (quantite < 10) {
            prixUnitaire = 150;
        } else if (quantite <= 49) {
            prixUnitaire = 135;
        } else {
            prixUnitaire = 110;
        }
        
        int montantTotal = quantite * prixUnitaire;
        
        System.out.println("\nRésultat :");
        System.out.println("----------");
        System.out.println("Quantité : " + quantite);
        System.out.println("Prix unitaire : " + prixUnitaire + " €");
        System.out.println("Montant total : " + montantTotal + " €");
        
        // Exemples de tests
        System.out.println("\nExemples de tests :");
        System.out.println("1. 9 articles : " + (9 * 150) + " €");
        System.out.println("2. 12 articles : " + (12 * 135) + " €");
        System.out.println("3. 50 articles : " + (50 * 110) + " €");
        
        scanner.close();
    }
}
