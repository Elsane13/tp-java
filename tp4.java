/**
 * Classe représentant une personne avec des méthodes pour calculer son IMC
 * et déterminer si c'est un adulte.
 */
public class Person {
    // Attributs
    private String nom;
    private int age;
    private double taille; // en mètres
    private double poids;  // en kilogrammes

    /**
     * Constructeur de la classe Person
     * @param nom Le nom de la personne
     * @param age L'âge de la personne en années
     * @param taille La taille en mètres
     * @param poids Le poids en kilogrammes
     */
    public Person(String nom, int age, double taille, double poids) {
        this.nom = nom;
        this.age = age;
        this.taille = taille;
        this.poids = poids;
    }

    /**
     * Calcule l'Indice de Masse Corporelle (IMC)
     * @return La valeur de l'IMC arrondie à 2 décimales
     */
    public double determineIMC() {
        if (taille <= 0) {
            throw new IllegalArgumentException("La taille doit être supérieure à 0");
        }
        double imc = poids / (taille * taille);
        return Math.round(imc * 100.0) / 100.0; // Arrondi à 2 décimales
    }

    /**
     * Détermine la signification de l'IMC selon la classification standard
     * @return Une chaîne décrivant la catégorie d'IMC
     */
    public String significationIMC() {
        if (age < 20 || age > 65) {
            return "L'IMC n'est pas interprétable pour cet âge";
        }
        
        double imc = determineIMC();
        
        if (imc < 18.5) {
            return "Maigreur - Poids inférieur à la normale";
        } else if (imc < 25) {
            return "Poids normal";
        } else if (imc < 30) {
            return "Surpoids";
        } else if (imc < 35) {
            return "Obésité, niveau 1 - Obésité modérée";
        } else {
            return "Obésité sévère";
        }
    }

    /**
     * Vérifie si la personne est majeure
     * @return true si la personne a 18 ans ou plus, false sinon
     */
    public boolean isAdult() {
        return age >= 18;
    }

    /**
     * Retourne une représentation textuelle de l'objet Person
     * @return Une chaîne décrivant la personne et son état
     */
    @Override
    public String toString() {
        return String.format("""
                Nom: %s
                Âge: %d ans
                Taille: %.2f m
                Poids: %.1f kg
                IMC: %.1f
                Statut: %s
                Adulte: %s""",
                nom, age, taille, poids, determineIMC(), 
                significationIMC(), 
                isAdult() ? "Oui" : "Non");
    }

    // Getters et Setters
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    
    public double getTaille() { return taille; }
    public void setTaille(double taille) { this.taille = taille; }
    
    public double getPoids() { return poids; }
    public void setPoids(double poids) { this.poids = poids; }

    /**
     * Méthode principale pour tester la classe Person
     */
    public static void main(String[] args) {
        // Création de deux personnes pour le test
        Person personne1 = new Person("Jean Dupont", 25, 1.75, 70);
        Person personne2 = new Person("Marie Martin", 17, 1.65, 55);
        
        // Affichage des informations
        System.out.println("=== Test de la classe Person ===\n");
        
        System.out.println("--- Personne 1 ---");
        System.out.println(personne1);
        
        System.out.println("\n--- Personne 2 ---");
        System.out.println(personne2);
        
        // Test de la modification des attributs
        System.out.println("\n=== Modification des attributs ===");
        personne1.setPoids(80);
        personne1.setAge(19);
        
        System.out.println("\n--- Personne 1 après modification ---");
        System.out.println(personne1);
    }
}
