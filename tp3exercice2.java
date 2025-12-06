import java.util.*;

public class tp3exercice2 {
    public static void main(String[] args) {
        // 1. Initialisation des ArrayList
        ArrayList<String> pays = new ArrayList<>(Arrays.asList(
            "France", "Allemagne", "Russie", "USA", "Chine"));
            
        ArrayList<Integer> population = new ArrayList<>(Arrays.asList(62, 82, 288, 200, 1290));
        
        // 2. Trouver le pays avec la population la plus faible
        int minPopulation = Collections.min(population);
        int indexMin = population.indexOf(minPopulation);
        System.out.println("Pays avec la population la plus faible : " + 
                          pays.get(indexMin) + " (" + minPopulation + " millions)");
        
        // 3. Afficher les pays avec plus de 200 millions d'habitants
        System.out.println("\nPays avec plus de 200 millions d'habitants :");
        for (int i = 0; i < pays.size(); i++) {
            if (population.get(i) > 200) {
                System.out.println("- " + pays.get(i) + " (" + population.get(i) + " millions)");
            }
        }
        
        // 4. Version avec HashMap
        System.out.println("\n--- Version avec HashMap ---");
        HashMap<String, Integer> paysPopulation = new HashMap<>();
        
        // Remplissage de la HashMap
        for (int i = 0; i < pays.size(); i++) {
            paysPopulation.put(pays.get(i), population.get(i));
        }
        
        // Recherche du pays avec la population la plus faible avec HashMap
        String paysMin = null;
        int minPop = Integer.MAX_VALUE;
        
        for (Map.Entry<String, Integer> entry : paysPopulation.entrySet()) {
            if (entry.getValue() < minPop) {
                minPop = entry.getValue();
                paysMin = entry.getKey();
            }
        }
        
        System.out.println("Pays avec la population la plus faible (HashMap) : " + 
                          paysMin + " (" + minPop + " millions)");
        
        // Affichage des pays avec plus de 200 millions avec HashMap
        System.out.println("\nPays avec plus de 200 millions d'habitants (HashMap) :");
        for (Map.Entry<String, Integer> entry : paysPopulation.entrySet()) {
            if (entry.getValue() > 200) {
                System.out.println("- " + entry.getKey() + " (" + entry.getValue() + " millions)");
            }
        }
    }
}
