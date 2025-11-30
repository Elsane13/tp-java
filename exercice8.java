import java.util.Scanner;

public class exercice8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== Afficheur de multiples ===");
        System.out.print("Entrez le nombre dont vous voulez les multiples : ");
        int nombre = scanner.nextInt();
        
        System.out.print("Entrez la limite maximale : ");
        int limite = scanner.nextInt();
        
        System.out.println("Les multiples de " + nombre + " jusqu'à " + limite + " sont :");
        for (int i = 1; i * nombre <= limite; i++) {
            System.out.print((i * nombre) + " ");
        }
        
        scanner.close();
    }
}
