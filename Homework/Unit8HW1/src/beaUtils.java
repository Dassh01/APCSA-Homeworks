
import java.util.Scanner;
import java.util.function.Function;

public class beaUtils {
    /**
     * Comes from retyping user prompts and scanner methods over and over in APCSA projects :C
     * Used to simplify above-mentioned process, does the prompt and scan all in one (now with an embedded try catch!) (InputMismatch be gone!)
     *
     * @param askText       [String] Prompt the user is asked in console
     * @param inputFunction [Scanner] lambda method (i.e: Scanner::nextLine, Scanner::nextInt), dependent on what data type you want the function to return as its return type is generic
     * @param scanner       [Scanner] (hopefully connected to System input...)
     * @return Returns data type dependent on the scanner lambda inserted
     */
    public static <T> T askForThing(String askText, Function<Scanner, T> inputFunction, Scanner scanner) {
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
}