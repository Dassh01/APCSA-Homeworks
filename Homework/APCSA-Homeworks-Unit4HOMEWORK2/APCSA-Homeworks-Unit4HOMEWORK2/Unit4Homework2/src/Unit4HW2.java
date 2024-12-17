
public class Unit4HW2 {

    /**
     * When called, displays the amount of each vowel present in parameter string
     * @param string [String] word to be processed into vowel components
     */
    public static void vowelCounter(String string) {
        final int A = 0, E = 1, I = 2, O = 3, U = 4;
        int[] vowelCount = new int[5];

        for (char letter : string.toCharArray()) {
            switch (Character.toLowerCase(letter)) {
                case 'a':
                    ++vowelCount[A];
                    break;
                case 'e':
                    ++vowelCount[E];
                    break;
                case 'i':
                    ++vowelCount[I];
                    break;
                case 'u':
                    ++vowelCount[U];
                    break;
                case 'o':
                    ++vowelCount[O];
            }

        }

        System.out.println((
                "\nNumber of a's: "+vowelCount[A]+
                "\nNumber of e's: "+vowelCount[E]+
                "\nNumber of i's: "+vowelCount[I]+
                "\nNumber of o's: "+vowelCount[O]+
                "\nNumber of u's: "+vowelCount[U]
        ));
    }

    /**
     * Determines if parameter string is a palindrome, also formats and returns. Will print an error message if a non alphabetical character is present
     * @param string [String] String to be assessed
     */
    public static void palindromeChecker(String string) {
        //Creates a StringBuilder object which we manipulate to determine if the word is the same back-to-front
        boolean isPalindrome = new StringBuilder(string.trim().toLowerCase()).reverse().toString().equals(string);
        if (containsInvalidCharacters(string)) {
            System.out.println( "Error: Invalid character detected in " + string );
        }
        else {
            System.out.println( isPalindrome ? string + " is a palindrome." : string + " is not a palindrome." );
        }

    }

    /**
     * Assists palindromeChecker, returns true if any characters are non-alphabetic in provided string, returns false if otherwise
     * @param string [String] string to be checked for invalid characters
     * @return true IF non-alphabetic characters are detected, false if not
     */
    public static boolean containsInvalidCharacters(String string) {
        for (char letter : string.toCharArray()) {
            if (!Character.isAlphabetic(letter)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        vowelCounter("The quick brown fox jumped over the lazy dog.");
        vowelCounter("aaeeeeiiiioouuuu");
        palindromeChecker("level");
        palindromeChecker("abcde");
        palindromeChecker("racecar");
        palindromeChecker("aBbA");
        //extra credit
        palindromeChecker("s*dfj*js");
        palindromeChecker("jf&fj");

    }
}
