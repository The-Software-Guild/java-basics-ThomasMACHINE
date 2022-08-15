import java.util.Random;
import java.util.Scanner;

public class DogGenetics {
    private static final String[] breedArray = {"Dramatic Rednosed Asian Pug", "Greyhound", "Huskey", "Labrador", "Chihuahua"};

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        // Prompt the users dog name and print it
        System.out.println("What is the name of your dog?");
        String dogName = s.next();
        System.out.println("Well then, I have this highly reliable report on " + dogName + "'s prestigious background right here");

        // Not the best as the long term results are - 50, 25, 12.5, 6.25, 3.125
        Random ran = new Random();
        int remainder = 100;
        for(int i = 0; i < 4; i++){
            // Find a random number between 0 and the remaining DNA - 1
            int percentage = ran.nextInt(0,(remainder));
            remainder -= percentage;

            System.out.println(breedArray[i] + ": " + percentage);
        }
        System.out.println(breedArray[4] + ": " + remainder);
        
    }
}
