import java.util.Scanner;

public class exercice3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int codePostal;
        do {
            System.out.print("Entrez un numéro de département (entre 1 et 99) : ");
            codePostal = scanner.nextInt();
            
            if (codePostal < 1 || codePostal > 99) {
                System.out.println("Erreur : le numéro de département doit être compris entre 1 et 99.");
            }
        } while (codePostal < 1 || codePostal > 99);
        
        if (estEnIleDeFrance(codePostal)) {
            System.out.println("Le département " + codePostal + " fait partie de l'Île-de-France.");
        } else {
            System.out.println("Le département " + codePostal + " ne fait pas partie de l'Île-de-France.");
        }
        
        scanner.close();
    }
    
    public static boolean estEnIleDeFrance(int codePostal) {
        return codePostal == 75 ||  // Paris
               codePostal == 77 ||  // Seine-et-Marne
               codePostal == 78 ||  // Yvelines
               codePostal == 91 ||  // Essonne
               codePostal == 92 ||  // Hauts-de-Seine
               codePostal == 93 ||  // Seine-Saint-Denis
               codePostal == 94 ||  // Val-de-Marne
               codePostal == 95;    // Val-d'Oise
    }
}
