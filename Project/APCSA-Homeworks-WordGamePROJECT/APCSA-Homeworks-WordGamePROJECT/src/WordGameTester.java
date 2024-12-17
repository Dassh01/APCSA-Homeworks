package word_games;
import java.util.Scanner;
import java.util.function.Function;

public class WordGameTester{

    //GLOBAL SCANNER YAYAY (thanks to Aaryan!)
    private static final Scanner scanner = new Scanner(System.in);
    //Build the wordContainer
    static WordGames wordContainer = new WordGames(askForThing("Enter a word: ",Scanner::nextLine));

    /**
     * Simplify the request to user input gathering process
     * @param askText [String], Text that the user is polled (asked) by
     * @param inputFunction [Lambda Function of type Scanner] ex: Scanner::nextLine, Scanner::nextInt
     * @return Respective generic data from the type of LambdaFunction inputted
     */
    private static <T> T askForThing(String askText, Function<Scanner, T> inputFunction) {
        //Talk about issues with a global scanner with Smith
        // Part where the user is asked for input
        System.out.println(askText);
        T returningInformation = inputFunction.apply(scanner);
        //instanceOf determines if returningInformation is an instance of the class Integer
        if (returningInformation instanceof Integer) {
            //Clear the buffer if the function being parsed is Scanner::nextInt
            //https://stackoverflow.com/questions/23036062/cant-use-scanner-nextint-and-scanner-nextline-together
            scanner.nextLine();
        }
        return returningInformation;
    }

    /**
     * Testing .scramble method
     */
    private static void testA() {
        String scrambledWord = wordContainer.scramble();
        System.out.println("Your central word but scrambled: "+scrambledWord);
    }

    /**
     * Testing overloaded method .bananaSplit
     */
    private static void testB() {
        //Polling
        int index;
        while (true) {
            try {
                index = askForThing("\nEnter an integer: ",Scanner::nextInt);
            }
            catch (Exception e) {
                System.out.println("Please enter one INTEGER");
                continue;
            }
            break;
        }
        String randomWord = askForThing("Enter a random word: ",Scanner::nextLine);
        //bananaSplit handles ArrayIndexOutOfBoundsException catching by itself
        String word = (wordContainer.bananaSplit(index,randomWord));
        System.out.println("Your random word inserted into your central word: "+word);
    }

    /**
     * Also testing overloaded method .bananaSplit :)
     */
    private static void testC() {

        //Initialize method variables
        boolean identifierIsLongerThen1Character = true;
        String identifier = "";
        
        String word = askForThing("\nPlease enter a random word: ",Scanner::nextLine);
        //Make sure that the character being entered is a character since we have to cast it to a string for some reason?? - ask Mr Smith if I can just simplify this to try catch
        //Also make sure we can insert the "character" into that word
        while(identifierIsLongerThen1Character || !wordContainer.hasCharacter(identifier)) {

            identifier = askForThing("Enter 1 Character that is present in your central word: ",Scanner::nextLine);

            //Determines if the string being pulled is actually just a character long
            identifierIsLongerThen1Character = identifier.length() > 1;
        }

        //Generate word to be printed
        String randomWordAtCharacter = wordContainer.bananaSplit(identifier,word);
        System.out.println("Your random word inserted at the character you specified in your central word: "+randomWordAtCharacter);
    }

    public static void main(String[] args){
        System.out.println("Your central word is: "+wordContainer+"!");
        // Ask for a word
        // Scramble it
        // Print out scrambled word
        testA();

        // Ask for index
        // Ask for random word
        // Add random word at index
        // Print out the word
        testB();
        
        // Ask for a character (store as a String)
        // Ask for random word
        // Add random word at character
        // Print out the word
        testC();
        
    }
}
