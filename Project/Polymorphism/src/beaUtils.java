import java.util.HashSet;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Supplier;

public class beaUtils {
    /**
     * Prompts, scans and retries input collection from a user.
     *
     * EXAMPLE USAGE: String input = beaUtils.askForThing("What is your favorite cat breed?", Scanner::nextLine, scanner)
     * The question that the user will be asked is "What is your favorite cat breed?", the method will expect a type String response due to
     * Scanner::nextLine being employed as the second parameter. Finally, the method will use an already present system input scanner.
     *
     * Automatically flushes Scanner buffer in case of int response.
     *
     * @param askText [String] Prompt the user is asked in console
     * @param inputFunction [Scanner] lambda method (i.e: Scanner::nextLine, Scanner::nextInt), dependent on what data type you want the function to return as its return type is generic
     * @param scanner [Scanner] (hopefully connected to System input...)
     * @return Returns data type dependent on the scanner lambda inserted
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
     * Interprets a string into a boolean. Worked with a (yes/no) or a (y/n) prompt, case-insensitive
     * @param userInput [String] Raw user input as answer to a prompt similar to the ones listed above
     * @return [Boolean] true IF user inputted something that looks like a yes, false if user inputted something that looks something other than a yes
     */
    protected static boolean userInputBoolean(String userInput) {
        String formattedUserInput = userInput.toLowerCase().trim();
        return formattedUserInput.equals("y") || formattedUserInput.contains("yes");
    }

    /**
     * Interprets a string into a boolean. Worked with a (yes/no) or a (y/n) prompt, case-insensitive.
     * The more manual/specific version that allows you to choose values that will return true
     * @param UserInput [String] Raw user input as answer to a prompt similar to the ones listed above
     * @param trueValues [HashSet] Values that, if user has entered the same, will make the method return true
     * @return [Boolean] true IF user inputted something that looks like a yes by the standards of the HashSet, false if user inputted something that looks something other than a yes
     */
    protected static boolean userInputBoolean(String UserInput, HashSet<String> trueValues) {
        String formattedUserInput = UserInput.toLowerCase().trim();
        return trueValues.contains(formattedUserInput);
    }

    /**
     * Retry provided code until it doesn't throw any errors
     * @param codeToRun Input lambda to run until it passes
     * @return Output of parameter lambda
     */
    private static <T> T retryUntilSuccess(Supplier<T> codeToRun) {
        while (true) {
            try {
                return codeToRun.get();
            } catch (Exception e) {
                System.out.println(e.getMessage() + ". Retrying...");
            }
        }
    }

    /**
     * Rounds the input param to the number of decimal places provided as the (int) second param
     * @param input Double to be rounded
     * @param decimalPlacesToRoundTo Decimal places to round to (EX: 4.2456 rounded to 2 would be 4.25) 
     * @return Formatted double rounded
     */
    public static double roundAsDouble(double input, int decimalPlacesToRoundTo) {
        double scale = Math.pow(10, decimalPlacesToRoundTo);
        return Math.round(input * scale) / scale;
    }

    /**
     * Rounds the input to the number of decimal places provided as the (int) second parameter
     * @param input Double to be rounded
     * @param decimalPlacesToRoundTo Decimal places to round to (EX: 4.2456 rounded to 2 would be 4.25)
     * @return Formatted string of double rounded
     */
    public static String roundAsString(double input, int decimalPlacesToRoundTo) {
        double rounded = roundAsDouble(input, decimalPlacesToRoundTo);
        return String.valueOf(rounded);
    }

    public static void halt(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

}