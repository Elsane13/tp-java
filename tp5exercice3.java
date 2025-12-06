import java.util.GregorianCalendar;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DVD {
    // Constantes pour les couleurs
    public static final char ROUGE = 'R';
    public static final char VERT = 'V';
    
    // Attributs
    private String titre;
    private char couleur;
    private GregorianCalendar dateSortie;
    
    /**
     * Constructeur par défaut
     */
    public DVD() {
        this.titre = "Sans titre";
        this.couleur = ROUGE; // Par défaut
        this.dateSortie = new GregorianCalendar(); // Date du jour
    }
    
    /**
     * Constructeur avec paramètres
     * @param titre le titre du DVD
     * @param couleur la couleur de l'étiquette (R ou V)
     * @param annee l'année de sortie
     * @param mois le mois de sortie (1-12)
     * @param jour le jour de sortie
     */
    public DVD(String titre, char couleur, int annee, int mois, int jour) {
        this.titre = (titre != null) ? titre : "Sans titre";
        setCouleur(couleur);
        this.dateSortie = new GregorianCalendar(annee, mois - 1, jour); // Mois commence à 0 dans Calendar
    }
    
    // Getters et Setters
    public String getTitre() {
        return titre;
    }
    
    public void setTitre(String titre) {
        if (titre != null && !titre.trim().isEmpty()) {
            this.titre = titre;
        }
    }
    
    public char getCouleur() {
        return couleur;
    }
    
    public void setCouleur(char couleur) {
        couleur = Character.toUpperCase(couleur);
        if (couleur == ROUGE || couleur == VERT) {
            this.couleur = couleur;
        } else {
            this.couleur = ROUGE; // Valeur par défaut si couleur invalide
        }
    }
    
    public GregorianCalendar getDateSortie() {
        return dateSortie;
    }
    
    public void setDateSortie(int annee, int mois, int jour) {
        this.dateSortie = new GregorianCalendar(annee, mois - 1, jour);
    }
    
    /**
     * Calcule le prix de location du DVD
     * @return le prix en euros
     */
    public double prixDVD() {
        switch (couleur) {
            case ROUGE:
                return 3.0;
            case VERT:
                return 2.0;
            default:
                return 0.0; // En cas d'erreur de couleur
        }
    }
    
    /**
     * Vérifie si le DVD est une nouveauté (sorti il y a moins de 3 mois)
     * @return true si c'est une nouveauté, false sinon
     */
    public boolean isNouveaute() {
        GregorianCalendar aujourdhui = new GregorianCalendar();
        GregorianCalendar dateLimite = new GregorianCalendar();
        dateLimite.add(Calendar.MONTH, -3); // Il y a 3 mois
        
        return dateSortie.after(dateLimite);
    }
    
    /**
     * Calcule la différence en jours entre deux dates
     * @param date1 la première date
     * @param date2 la deuxième date
     * @return la différence en jours
     */
    private static long differenceEnJours(GregorianCalendar date1, GregorianCalendar date2) {
        long diffInMillies = Math.abs(date1.getTimeInMillis() - date2.getTimeInMillis());
        return TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
    }
    
    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String dateStr = sdf.format(dateSortie.getTime());
        String couleurStr = (couleur == ROUGE) ? "Rouge" : "Vert";
        
        return String.format("DVD '%s' (%s) - Sorti le %s - Prix: %.2f€/jour",
                titre, couleurStr, dateStr, prixDVD());
    }
    
    /**
     * Méthode principale pour tester la classe DVD
     */
    public static void main(String[] args) {
        // 1. Afficher la date du jour
        GregorianCalendar aujourdhui = new GregorianCalendar();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Date du jour : " + sdf.format(aujourdhui.getTime()));
        
        // 2. Créer une date spécifique (10 février 2013)
        GregorianCalendar dateSpecifique = new GregorianCalendar(2013, 1, 10); // Février = 1 (0-based)
        System.out.println("Date spécifique : " + sdf.format(dateSpecifique.getTime()));
        
        // 3. Calculer la différence en jours
        long differenceJours = differenceEnJours(aujourdhui, dateSpecifique);
        System.out.println("Différence avec aujourd'hui : " + differenceJours + " jours");
        
        // 4. Tester la classe DVD
        System.out.println("\n=== Test de la classe DVD ===");
        
        // a) Création d'un DVD
        DVD dvd1 = new DVD("La Porte", 'R', 2006, 2, 5); // 05/02/2006
        System.out.println("\nDVD initial : " + dvd1);
        
        // b) Modification du titre
        dvd1.setTitre("La Porte des Secrets");
        System.out.println("Après modification du titre : " + dvd1);
        
        // c) Affichage du prix de location
        System.out.println("Prix de location : " + dvd1.prixDVD() + "€/jour");
        
        // d) Vérification si c'est une nouveauté
        System.out.println("Est une nouveauté ? " + 
                         (dvd1.isNouveaute() ? "Oui" : "Non"));
        
        // Test avec un DVD plus récent
        GregorianCalendar ilYA2Mois = new GregorianCalendar();
        ilYA2Mois.add(Calendar.MONTH, -2);
        
        DVD dvd2 = new DVD("Nouveau Film", 'V',
                          ilYA2Mois.get(Calendar.YEAR),
                          ilYA2Mois.get(Calendar.MONTH) + 1,
                          ilYA2Mois.get(Calendar.DAY_OF_MONTH));
        
        System.out.println("\nDVD récent : " + dvd2);
        System.out.println("Est une nouveauté ? " + 
                         (dvd2.isNouveaute() ? "Oui" : "Non"));
    }
}
