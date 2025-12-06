import java.util.Scanner;

public class tp2exercice6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Entrez votre nom : ");
        String nom = scanner.nextLine().trim();
        
        System.out.print("Entrez votre prénom : ");
        String prenom = scanner.nextLine().trim();
        
        // Formater le nom (tout en majuscules)
        String nomFormate = nom.toUpperCase();
        
        // Formater le prénom (gestion des prénoms composés)
        String[] partiesPrenom = prenom.split("[- ]");
        StringBuilder prenomFormate = new StringBuilder();
        
        for (int i = 0; i < partiesPrenom.length; i++) {
            if (!partiesPrenom[i].isEmpty()) {
                if (i > 0) {
                    prenomFormate.append("-");
                }
                prenomFormate.append(partiesPrenom[i].substring(0, 1).toUpperCase())
                            .append(partiesPrenom[i].substring(1).toLowerCase());
            }
        }
        
        // Compter le nombre total de caractères du prénom (y compris les tirets)
        int longueurPrenom = prenom.length();
        
        System.out.println(nomFormate + " (" + nom.length() + ") " + 
                          prenomFormate + " (" + longueurPrenom + ")");
        
        scanner.close();
    }
}
