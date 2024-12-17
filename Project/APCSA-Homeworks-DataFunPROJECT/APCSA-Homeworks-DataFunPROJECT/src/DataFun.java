import java.util.Scanner;
import java.util.function.Function;

/**
 * Data Fun
 * @author Beatrice Gilfix
 * @version [11/12/2024]
 */

public class DataFun {
    private static final Scanner sysinp = new Scanner(System.in);
    // Color Library
    private static final String RESET = "\033[0m";
    public static final String RED = "\033[0;31m";
    public static final String GREEN = "\033[0;32m";
    public static final String YELLOW = "\033[0;33m";
    public static final String BLUE = "\033[0;34m";
    public static final String PURPLE = "\033[0;35m";
    public static final String CYAN = "\033[0;36m";
    public static final String GREY = "\033[0;37m";

    /**
     * Taken from beaUtils @ <a href="https://github.com/Dassh01/beaUtils">...</a>"
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
     * Handles the first part of the DataFun project
     * @param integer User's 'favorite integer'
     * @param CHOSEN_COLOR User's chosen color theme
     * @return Compiled string as per favorite integer reqs
     */
    private static String partOne(int integer, String CHOSEN_COLOR) {
        //Declare variables

        //Scope obfuscation?
        //What even is that! :)
        String isPositiveOrNegative;
        String isGreaterThan;
        String isOddOrEven;
        String isNobleGas;

        isPositiveOrNegative = integer >= 0 ?  CHOSEN_COLOR + "positive" + RESET : CHOSEN_COLOR + "negative" + RESET;

        isOddOrEven = integer % 2 == 0 ? CHOSEN_COLOR + "even" + RESET : CHOSEN_COLOR + "odd" + RESET;
        if (integer <= 10) {
            isGreaterThan = "";
        }
        else if (integer <= 100) {
            isGreaterThan = ",\nit is" + CHOSEN_COLOR + " greater then 10" + RESET;
        }
        else if (integer <= 1000) {
            isGreaterThan = ",\nit is" + CHOSEN_COLOR + " greater then 100" + RESET;
        }
        else {
            isGreaterThan = ",\nit is" + CHOSEN_COLOR +  " greater then 1000" + RESET;
        }

        isNobleGas = switch (integer) {
            case 2 -> "the noble gas" + CHOSEN_COLOR +  " Helium" + RESET;
            case 10 -> "the noble gas" + CHOSEN_COLOR + " Neon" + RESET;
            case 18 -> "the noble gas" + CHOSEN_COLOR + "Argon" + RESET;
            case 36 -> "the noble gas" + CHOSEN_COLOR + "Krypton" + RESET;
            case 54 -> "the noble gas" + CHOSEN_COLOR + "Xenon" + RESET;
            case 86 -> "the noble gas" + CHOSEN_COLOR + "Radon" + RESET;
            default -> CHOSEN_COLOR + "not" + RESET + " the atomic number of a noble gas";
        };
        //Compiled string here
        return (integer + " is a "+ isPositiveOrNegative + " number"+isGreaterThan+",\nit is "+isOddOrEven+",\nand it is "+isNobleGas+"\n");
    }

    /**
     * Handles the second part of the DataFun project
     * @param character User's 'favorite character'
     * @param CHOSEN_COLOR User's chosen color theme
     * @return Compiled string as per part 2's reqs
     */
    private static String partTwo(char character, String CHOSEN_COLOR) {
        //Declare variables
        final char characterLowercase = Character.toLowerCase(character);
        final int asciiValue;
        final boolean isCharacterLowercase = Character.isLowerCase(character);

        String characterStatus;
        String isVowel;
        String suffix;
        String alphabeticalStatus;
        int alphabeticalPlacement;

        asciiValue = character;

        if (Character.isDigit(character)) {
            characterStatus = " is a " + CHOSEN_COLOR + "number" + RESET + ",\n";
            isVowel = "";
        }
        else if (Character.isLetter(character)) {
            if (isCharacterLowercase) {
                characterStatus = " is a " + CHOSEN_COLOR + "lower case" + RESET + " letter,\n";
            }
            else {
                characterStatus = " is an " + CHOSEN_COLOR + "upper case" + RESET + " letter,\n";
            }
            isVowel = characterLowercase == 'a' || characterLowercase == 'e' || characterLowercase == 'i' || characterLowercase == 'o' || characterLowercase == 'u' ? "it is a " + CHOSEN_COLOR + "vowel" + RESET + ",\n" : "it is a " + CHOSEN_COLOR + "consonant" + RESET + ",\n";
        }
        else {
            characterStatus = " is " + CHOSEN_COLOR + "not a letter or number" + RESET + ",\n";
            isVowel = "";
        }

        if (isCharacterLowercase) {
            alphabeticalPlacement = asciiValue - 96;
        }
        else {
            alphabeticalPlacement = asciiValue - 64;
        }

        //Handle suffix
        if (alphabeticalPlacement == 11 || alphabeticalPlacement == 12 || alphabeticalPlacement == 13) {
            suffix = "th";
        }
        else {
            suffix = switch (alphabeticalPlacement % 10) {
                case 1 -> "st";
                case 2 -> "nd";
                case 3 -> "rd";
                default -> "th";
            };
        }

        //Final catch handling the last message in part two if character isn't in the alphabet
        alphabeticalStatus = Character.isLetter(character) ? "the " + CHOSEN_COLOR + alphabeticalPlacement + suffix + RESET + " letter of the alphabet" : CHOSEN_COLOR + "not present "+ RESET + "in the alphabet";

        return (character + characterStatus + isVowel + "its ASCII value is " + CHOSEN_COLOR + asciiValue + RESET + ",\nand it is " + alphabeticalStatus);

    }

    /**
     * Handles polling for the color
     * @param userColorRequest User's request for color theme as an unformatted string (string formatting is handled in-method)
     * @return Returns respective color ANSI code to be fed into partOne/Two
     */
    private static String pollForColor(String userColorRequest) {
        String color;

        color = switch (userColorRequest.trim().toLowerCase()) {
            case "red" -> RED;
            case "green" -> GREEN;
            case "yellow" -> YELLOW;
            case "blue" -> BLUE;
            case "purple" -> PURPLE;
            case "cyan" -> CYAN;
            case "grey" -> GREY;
            default -> {
                System.out.println("Color not recognized, defaulting to white.");
                yield GREY;
            }
        };
        return color;
    }

    public static void main(String[] args) {
        String chosenColor = pollForColor(askForThing("Enter a color to act as a theme, \n(AVAILABLE: Red, Green, Yellow, Blue, Purple, Cyan, Grey):", Scanner::next, sysinp));
        System.out.println(partOne(askForThing("Enter your favorite integer: ", Scanner::nextInt, sysinp), chosenColor));
        System.out.println(partTwo(askForThing("Enter your favorite character", Scanner::next, sysinp).charAt(0), chosenColor));
    }
}