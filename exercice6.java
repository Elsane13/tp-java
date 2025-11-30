import java.util.Scanner;

public class Compteur {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== Compteur ===");
        System.out.print("Jusqu'à quel nombre voulez-vous compter ? ");
        int limite = scanner.nextInt();
        
        System.out.println("Comptage de 1 à " + limite + " :");
        for (int i = 1; i <= limite; i++) {
            System.out.print(i + " ");
        }
        
        scanner.close();
    }
}
