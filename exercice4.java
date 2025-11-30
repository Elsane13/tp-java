import java.util.Scanner;

public class exercice4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Entrez le premier nombre : ");
        int nb1 = scanner.nextInt();
        
        System.out.print("Entrez le deuxième nombre : ");
        int nb2 = scanner.nextInt();
        
        if ((nb1 < 0 && nb2 < 0) || (nb1 > 0 && nb2 > 0)) {
            System.out.println("Le produit est positif");
        } else if (nb1 == 0 || nb2 == 0) {
            System.out.println("Le produit est nul");
        } else {
            System.out.println("Le produit est négatif");
        }
        
        scanner.close();
    }
}
