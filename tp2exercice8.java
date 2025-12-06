import java.util.Scanner;

public class tp2exercice8 {
    // Méthode pour calculer la somme des chiffres d'un nombre
    public static int sommeChiffres(int nombre) {
        int somme = 0;
        int n = Math.abs(nombre); // Gérer les nombres négatifs
        
        while (n > 0) {
            somme += n % 10; // Ajouter le dernier chiffre
            n /= 10;         // Supprimer le dernier chiffre
        }
        return somme;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Entrez le premier nombre entier : ");
        int nombre1 = scanner.nextInt();
        
        System.out.print("Entrez le deuxième nombre entier : ");
        int nombre2 = scanner.nextInt();
        
        int somme1 = sommeChiffres(nombre1);
        int somme2 = sommeChiffres(nombre2);
        
        System.out.println("Nombre 1 : " + nombre1 + " (somme des chiffres : " + somme1 + ")");
        System.out.println("Nombre 2 : " + nombre2 + " (somme des chiffres : " + somme2 + ")");
        
        if (somme1 == somme2) {
            System.out.println("Ces deux nombres sont amis car la somme de leurs chiffres est égale (" + somme1 + ").");
        } else {
            System.out.println("Ces deux nombres ne sont pas amis car la somme de leurs chiffres est différente.");
        }
        
        scanner.close();
    }
}
