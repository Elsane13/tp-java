import java.util.Arrays;

public class Nombre {
    private int valeur;
    private static final int[] NOMBRES_PARFAITS = {6, 28, 496, 8128, 33550336};
    
    public Nombre(int valeur) {
        this.valeur = Math.abs(valeur); // On travaille avec la valeur absolue
    }
    
    /**
     * Calcule le nombre de diviseurs du nombre
     * @return le nombre de diviseurs
     */
    public int nombreDiviseurs() {
        if (valeur == 0) return 0; // 0 a une infinité de diviseurs
        if (valeur == 1) return 1; // 1 n'a qu'un seul diviseur
        
        int compteur = 2; // 1 et le nombre lui-même sont déjà des diviseurs
        for (int i = 2; i <= Math.sqrt(valeur); i++) {
            if (valeur % i == 0) {
                if (i == valeur / i) {
                    compteur++; // Carré parfait
                } else {
                    compteur += 2; // Deux diviseurs (i et valeur/i)
                }
            }
        }
        return compteur;
    }
    
    /**
     * Vérifie si le nombre est premier
     * @return true si le nombre est premier, false sinon
     */
    public boolean estPremier() {
        if (valeur < 2) return false;
        if (valeur == 2) return true;
        if (valeur % 2 == 0) return false;
        
        for (int i = 3; i * i <= valeur; i += 2) {
            if (valeur % i == 0) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * Vérifie si le nombre est parfait
     * @return true si le nombre est parfait, false sinon
     */
    public boolean estParfait() {
        // Vérification dans le tableau des nombres parfaits connus
        for (int parfait : NOMBRES_PARFAITS) {
            if (valeur == parfait) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Calcule la somme des diviseurs propres (sans le nombre lui-même)
     * @return la somme des diviseurs propres
     */
    private int sommeDiviseursPropres() {
        if (valeur <= 1) return 0;
        
        int somme = 1; // 1 est un diviseur propre pour tout n > 1
        for (int i = 2; i <= Math.sqrt(valeur); i++) {
            if (valeur % i == 0) {
                if (i == valeur / i) {
                    somme += i;
                } else {
                    somme += i + (valeur / i);
                }
            }
        }
        return somme;
    }
    
    /**
     * Vérifie si ce nombre est ami avec un autre nombre
     * @param nb l'autre nombre à tester
     * @return true si les nombres sont amis, false sinon
     */
    public boolean estAmi(Nombre nb) {
        if (nb == null) return false;
        if (this.valeur == nb.valeur) return false; // Un nombre ne peut pas être ami avec lui-même
        
        return (this.sommeDiviseursPropres() == nb.valeur && 
                nb.sommeDiviseursPropres() == this.valeur);
    }
    
    // Getters et Setters
    public int getValeur() {
        return valeur;
    }
    
    public void setValeur(int valeur) {
        this.valeur = Math.abs(valeur);
    }
    
    @Override
    public String toString() {
        return "Nombre : " + valeur;
    }
    
    // Méthode main pour tester la classe
    public static void main(String[] args) {
        // Création de quelques nombres pour les tests
        Nombre n1 = new Nombre(6);
        Nombre n2 = new Nombre(28);
        Nombre n3 = new Nombre(12);
        Nombre n4 = new Nombre(220);
        Nombre n5 = new Nombre(284);
        
        // Affichage des informations
        testNombre(n1);
        testNombre(n2);
        testNombre(n3);
        testNombre(n4);
        testNombre(n5);
        
        // Test des nombres amis
        System.out.println("\n--- Test des nombres amis ---");
        System.out.println(n4 + " et " + n5 + " sont amis ? " + n4.estAmi(n5));
        System.out.println(n1 + " et " + n2 + " sont amis ? " + n1.estAmi(n2));
    }
    
    // Méthode utilitaire pour afficher les propriétés d'un nombre
    private static void testNombre(Nombre n) {
        System.out.println("\n" + n);
        System.out.println("Nombre de diviseurs : " + n.nombreDiviseurs());
        System.out.println("Est premier ? " + n.estPremier());
        System.out.println("Est parfait ? " + n.estParfait());
    }
}
