import java.util.Scanner;

public class tp2exercice5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrez une phrase : ");
        String phrase = scanner.nextLine();
        
        if (phrase.length() > 10) {
            System.out.println(phrase.substring(0, 10) + "...");
        } else {
            System.out.println(phrase);
        }
        
        scanner.close();
    }
}
