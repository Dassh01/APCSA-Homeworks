import java.util.Scanner;
import java.util.function.Function;

public class Unit4HW1 {

    /**
     * Taken from beaUtils @ <a href="https://github.com/Dassh01/beaUtils">...</a>
     * Look there for documentation, not here... or let us submit multiple file projects C:
     */
    protected static <T> T askForThing(String askText, Function<Scanner, T> inputFunction, Scanner scanner) {
        System.out.println(askText);
        T returningInformation;
        while (true) {
            try {
                returningInformation = inputFunction.apply(scanner);
                if (returningInformation instanceof Integer) {
                    scanner.nextLine();
                }
            } catch (Exception e) {
                scanner.nextLine();
                System.out.println(askText);
                continue;
            }
            break;
        }
        return returningInformation;
    }

    /**
     * Picks a random number between 1 and 100 and asks the user
     * to guess it. For each guess, the program should tell the user whether
     * the guess is too high, too low, or correct.
     * @param scanner Scanner connected to system input
     */
    private static void guessingGame(Scanner scanner){
        //Initial ask
        System.out.println("I'm thinking of a number between 1 and 100.");
        System.out.println("See if you can guess the number!");

        //Declare variables outside of loop to save the garbage collector some time
        int secretNumber = (int) (Math.random() * 100 + 1);
        int userGuess = askForThing("Enter your guess: ",Scanner::nextInt,scanner);
        String prefix;

        while (secretNumber != userGuess) {
            prefix = secretNumber > userGuess ? "Higher! " : "Lower! ";
            System.out.println(prefix+"Try again!");
            userGuess = askForThing("Enter your guess: ",Scanner::nextInt,scanner);
        }
        System.out.println("Correct!");
    }

    /**
     * Tired Turtle
     * Asks the user how many steps they want the turtle to take in its
     * first move. Then it calculates and displays how many total steps
     * the turtle took until it stopped.
     * @param scanner Scanner connected to system input
     */
    private static void tiredTurtle(Scanner scanner) {
        //Declare variables outside of loop to save the garbage collector some time
        int startingSteps = askForThing("How many steps should the turtle take on it's first move?",Scanner::nextInt,scanner);
        int totalSteps = 0;
        while (startingSteps > 0) {
            totalSteps += startingSteps;
            startingSteps /= 2;
        }
        System.out.println("Total steps taken by the turtle: " + totalSteps);
    }

    private static boolean yesOrNo (String input) {
        input = input.toLowerCase();
        return input.equals("y") || input.equals("yes");
    }

    /**
     * Tiny tamagotchi game
     * You manage a hungry pet
     * @param scanner Scanner connected to system input
     */
    private static void notATamagotchi(Scanner scanner){
        //Declare variables outside of loop to save the garbage collector some time
        int hungerLevel = 10;
        boolean wantToFeedPet;
        //This boolean determines the end result of the game
        boolean petAlive = true;

        for (int hour = 1; hour < 5; ++hour) {
            System.out.println("Current hunger level is "+hungerLevel);
            wantToFeedPet = yesOrNo(askForThing("Do you want to feed your pet? (y/n)",Scanner::nextLine,scanner));

            if (wantToFeedPet) {
                //Check to not bring hungerLevel into negatives
                hungerLevel = Math.max((hungerLevel - 25), 0);
            }
            else {
                hungerLevel += 10;
            }

            if (hungerLevel >= 50) {
                petAlive = false;
            } else if (hungerLevel >= 40) {
                System.out.println("You should feed your pet soon, it is unhappy");
            }
        }

        if (petAlive) {
            System.out.println("End of simulation. Your pet is content.");
        }
        else {
            System.out.println("End of simulation. Your pet is dead.");
        }
        System.out.println("--------------------------------------------");
    }

    public static void main(String[] args) {
        Scanner sysinp = new Scanner(System.in);
        guessingGame(sysinp);
        tiredTurtle(sysinp);
        notATamagotchi(sysinp);
    }
}
