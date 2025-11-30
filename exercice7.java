import java.util.Scanner;

public class exercice7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Entrez un nombre : ");
        int nombre = scanner.nextInt();
        
        if (nombre % 2 == 0) {
            System.out.println(nombre + " est un nombre pair");
            System.out.print("Les 10 nombres pairs suivants sont : ");
            for (int i = 1; i <= 10; i++) {
                System.out.print((nombre + 2 * i) + " ");
            }
        } else {
            System.out.println(nombre + " est un nombre impair");
            System.out.print("Les 10 nombres impairs suivants sont : ");
            for (int i = 1; i <= 10; i++) {
                System.out.print((nombre + 2 * i) + " ");
            }
        }
        
        scanner.close();
    }
}
