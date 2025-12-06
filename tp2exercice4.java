import java.util.Scanner;

public class tp2exercice4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Entrez votre nom : ");
        String nom = scanner.nextLine().trim();
        
        System.out.print("Entrez votre prénom : ");
        String prenom = scanner.nextLine().trim();
        
        // Formater le nom (tout en majuscules) et le prénom (première lettre en majuscule, le reste en minuscules)
        String nomFormate = nom.toUpperCase();
        String prenomFormate = prenom.isEmpty() ? "" : 
            prenom.substring(0, 1).toUpperCase() + prenom.substring(1).toLowerCase();
        
        System.out.println(nomFormate + " (" + nom.length() + ") " + 
                          prenomFormate + " (" + prenom.length() + ")");
        
        scanner.close();
    }
}
