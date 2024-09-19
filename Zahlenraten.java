import java.util.Scanner;
import java.util.Random;

public class Zahlenraten {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Rate eine Zahl zwischen 1 und 100: ");
        Random random = new Random();

        int zahl = random.nextInt(100) +1;
        int eingabe = scanner.nextInt();
        int maxVersuche = 10;
        int verbkeibendeVersuche = maxVersuche;

        verbkeibendeVersuche--;

        while (eingabe != zahl && verbkeibendeVersuche > 1) {
            if (eingabe > zahl) {
                System.out.println("Zu hoch!");
            } else {
                System.out.println("Zu niedrig!");
            }

            verbkeibendeVersuche--;
            System.out.println("Du hast noch " + verbkeibendeVersuche + " Versuche");
            System.out.println("Versuche es nochmal: ");
            eingabe = scanner.nextInt();

        } 
        if (eingabe == zahl) {
            System.out.println("Richtig!!! Du hast die Zahl erraten. ");
        }else {
            System.out.println("Leider, keine Versuche mehr! Die richtige Zahl war: " + zahl);

        }
        
    }
}