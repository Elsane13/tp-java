import java.util.*;

public class tp3exercice3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Entrez une phrase (sans ponctuation) :");
        String phrase = scanner.nextLine().toLowerCase();
        
        // Tableau pour stocker le nombre de mots par longueur (indice 0 non utilisé)
        int[] longueursMots = new int[31]; // Indices de 0 à 30
        
        // Découpage de la phrase en mots
        String[] mots = phrase.split("\\s+");
        
        // Comptage des longueurs de mots
        for (String mot : mots) {
            int longueur = mot.length();
            if (longueur > 0 && longueur <= 30) {
                longueursMots[longueur]++;
            }
        }
        
        // Affichage des résultats
        System.out.println("\nRésultat :");
        for (int i = 1; i < longueursMots.length; i++) {
            if (longueursMots[i] > 0) {
                System.out.println(i + " : " + longueursMots[i] + 
                                 " (" + longueursMots[i] + " mot" + 
                                 (longueursMots[i] > 1 ? "s" : "") + " de " + i + " lettre" +
                                 (i > 1 ? "s" : "") + ")");
            }
        }
        
        scanner.close();
    }
}
