import java.util.Scanner;

public class tp2exercice1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrez un verbe à l'infinitif : ");
        String verbe = scanner.nextLine().toLowerCase().trim();
        
        if (verbe.endsWith("er")) {
            System.out.println("Le verbe \"" + verbe + "\" appartient au 1er groupe.");
        } else if (verbe.endsWith("ir")) {
            System.out.println("Le verbe \"" + verbe + "\" appartient au 2ème groupe.");
        } else if (verbe.endsWith("oir") || verbe.endsWith("oire")) {
            System.out.println("Le verbe \"" + verbe + "\" appartient au 3ème groupe.");
        } else {
            System.out.println("Le verbe \"" + verbe + "\" n'est pas reconnu ou ne respecte pas les règles simplifiées.");
        }
        
        scanner.close();
    }
}