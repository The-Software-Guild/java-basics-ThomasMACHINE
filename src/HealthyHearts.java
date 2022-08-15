import java.util.Scanner;

public class HealthyHearts {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("What is your age?");

        int age = s.nextInt();
        int maxHR = 220 - age;
        System.out.println("Your maximum heart rate should be: " + maxHR + " beats per minute");
        System.out.println("Your target HR zone is: " + (int)(maxHR * 0.5) + " - " + (int)(maxHR * 0.8) + " beats per minute");
    }
}
