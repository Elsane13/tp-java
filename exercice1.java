import java.util.Scanner;

public class exercice1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Partie a) Saisie du nom
        System.out.print("Entrez votre nom : ");
        String nom = scanner.nextLine();
        System.out.println("Bonjour " + nom);
        
        // Partie b) Opérations sur deux nombres
        System.out.print("Entrez le premier nombre : ");
        int nb1 = scanner.nextInt();
        System.out.print("Entrez le deuxième nombre : ");
        int nb2 = scanner.nextInt();
        
        System.out.println("\nRésultats :");
        System.out.println("-----------");
        System.out.println("Somme : " + (nb1 + nb2));
        System.out.println("Différence : " + (nb1 - nb2));
        System.out.println("Produit : " + (nb1 * nb2));
        
        if (nb2 != 0) {
            System.out.println("Quotient : " + ((double)nb1 / nb2));
        } else {
            System.out.println("Division par zéro impossible");
        }
        
        scanner.close();
    }
}
