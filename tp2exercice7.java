import java.util.Scanner;

public class tp2exercice7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrez un mot : ");
        String mot = scanner.nextLine().toLowerCase().replaceAll("\\s+", "");
        
        boolean estPalindrome = true;
        int debut = 0;
        int fin = mot.length() - 1;
        
        while (debut < fin) {
            if (mot.charAt(debut) != mot.charAt(fin)) {
                estPalindrome = false;
                break;
            }
            debut++;
            fin--;
        }
        
        if (estPalindrome) {
            System.out.println("\"" + mot + "\" est un palindrome.");
        } else {
            System.out.println("\"" + mot + "\" n'est pas un palindrome.");
        }
        
        scanner.close();
    }
}
