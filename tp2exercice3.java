import java.util.Scanner;

public class tp2exercice3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrez un mot : ");
        String mot = scanner.nextLine().trim();
        
        if (!mot.isEmpty()) {
            System.out.println("Première lettre : " + mot.charAt(0));
            System.out.println("Dernière lettre : " + mot.charAt(mot.length() - 1));
            System.out.println("Nombre de lettres : " + mot.length());
        } else {
            System.out.println("Aucun mot saisi.");
        }
        
        scanner.close();
    }
}
