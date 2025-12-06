import java.util.Scanner;

public class tp2exercice2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrez une phrase : ");
        String phrase = scanner.nextLine();
        
        if (phrase.length() < 20) {
            System.out.println("phrase courte");
        } else if (phrase.length() < 50) {
            System.out.println("phrase de longueur moyenne");
        } else {
            System.out.println("phrase longue");
        }
        
        scanner.close();
    }
}