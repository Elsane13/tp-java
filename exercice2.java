import java.util.Scanner;

public class exercice2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrez votre âge : ");
        int age = scanner.nextInt();
        
        if (age < 26 || age > 65) {
            System.out.println("Vous avez droit au tarif réduit !");
        } else {
            System.out.println("Le tarif réduit ne s'applique pas à votre âge.");
        }
        
        scanner.close();
    }
}
