import java.util.*;

public class tp3exercice1 {
    public static void main(String[] args) {
        // 1. Initialisation du tableau de 10 entiers aléatoires
        int[] tabInt = new int[10];
        Random random = new Random();
        
        // Initialisation avec une boucle
        System.out.print("Tableau initial : ");
        for (int i = 0; i < tabInt.length; i++) {
            tabInt[i] = random.nextInt(101); // Génère un nombre entre 0 et 100
            System.out.print(tabInt[i] + " ");
        }
        System.out.println();
        
        // 2. Calcul de la somme, minimum et maximum
        int somme = 0;
        int min = tabInt[0];
        int max = tabInt[0];
        
        for (int i = 0; i < tabInt.length; i++) {
            somme += tabInt[i];
            if (tabInt[i] < min) {
                min = tabInt[i];
            }
            if (tabInt[i] > max) {
                max = tabInt[i];
            }
        }
        
        System.out.println("Somme : " + somme);
        System.out.println("Minimum : " + min);
        System.out.println("Maximum : " + max);
        
        // 3. Séparation en tableaux pairs et impairs
        int[] tabPair = new int[10];
        int[] tabImpair = new int[10];
        int nbPairs = 0;
        int nbImpairs = 0;
        
        for (int i = 0; i < tabInt.length; i++) {
            if (tabInt[i] % 2 == 0) {
                tabPair[nbPairs] = tabInt[i];
                nbPairs++;
            } else {
                tabImpair[nbImpairs] = tabInt[i];
                nbImpairs++;
            }
        }
        
        // Affichage des tableaux pairs et impairs
        System.out.print("Nombres pairs : ");
        for (int i = 0; i < nbPairs; i++) {
            System.out.print(tabPair[i] + " ");
        }
        System.out.println("\nNombre de pairs : " + nbPairs);
        
        System.out.print("Nombres impairs : ");
        for (int i = 0; i < nbImpairs; i++) {
            System.out.print(tabImpair[i] + " ");
        }
        System.out.println("\nNombre d'impairs : " + nbImpairs);
        
        // 4. Version avec ArrayList
        System.out.println("\n--- Version avec ArrayList ---");
        
        List<Integer> listEntier = new ArrayList<>();
        List<Integer> listEntierPair = new ArrayList<>();
        List<Integer> listEntierImpair = new ArrayList<>();
        
        // Remplissage de la liste principale
        for (int i = 0; i < 10; i++) {
            int nombre = random.nextInt(101);
            listEntier.add(nombre);
            
            if (nombre % 2 == 0) {
                listEntierPair.add(nombre);
            } else {
                listEntierImpair.add(nombre);
            }
        }
        
        // Affichage des listes
        System.out.println("Liste complète : " + listEntier);
        System.out.println("Nombres pairs : " + listEntierPair);
        System.out.println("Nombres impairs : " + listEntierImpair);
        
        // Calcul du min et max avec Collections
        System.out.println("Minimum (ArrayList) : " + Collections.min(listEntier));
        System.out.println("Maximum (ArrayList) : " + Collections.max(listEntier));
    }
}