package word_games;

public class WordGames {
    private final String word;

    /**
     * Constructor fun!
     * @param word [String] defines field word
     */
    public WordGames(String word){
        this.word = word;
    }

    /**
     * Switches the first half and the second half of the field word
     * @return the second half in front of the first half of the field word
     */
    public String scramble(){
        // switch first half
        // and second half
        int splitPos = word.length()/2;
        String firstHalf = word.substring(0,splitPos);
        String secondHalf = word.substring(splitPos);
        return secondHalf+firstHalf;
    }

    /**
     * Inserts word at index position of insertIdx
     * @param insertIdx [int] Index position to insert insertText
     * @param insertText [String] String to be inserted at InsertIdx index position
     * @return word field but with
     */
    public String bananaSplit(int insertIdx, String insertText){
        // Insert insertText at the position
        // insertIdx

        //In case it's going to attempt to access and index that doesn't exist
        if (insertIdx > word.length()) {
            //Send back the attempted insert word just at the end of the field word
            return word+insertText;
        }
        else {
            //Compile the string as usual
            String firstHalf = word.substring(0,insertIdx);
            String secondHalf = word.substring(insertIdx);
            return firstHalf+insertText+secondHalf;
        }
    }

    /**
     * Inserts insertText at first occurrence of insertChar
     * @param insertChar [String] Character for the insertText to be placed at (targets first instance of that character)
     * @param insertText [String] Text to be inserted at the first occurrence of insertChar
     * @return Compiled String
     */
    public String bananaSplit(String insertChar, String insertText){
        // Insert insertText after the first
        // occurrence of the insertChar

        //.indexOf pulls the position of the first occurrence of the specified character
        int splitPos = word.indexOf(insertChar);
        //Move the bounds of the splitPos index forward one
        //so that our word being inserted comes AFTER the specified character
        ++splitPos;
        //Compile the string
        String firstHalf = word.substring(0,splitPos);
        String secondHalf = word.substring(splitPos);
        return firstHalf+insertText+secondHalf;
    }

    /**
     * Useful for checking if bananaSplit(String, String) can be run without erroring
     * @param ch [String] one character please please
     * @return true if field word has that character, false if field word doesn't have that character
     */
    public boolean hasCharacter(String ch) {
        return word.contains(ch);
    }

    /**
     * The field word with some hard brackets around it :)
     * @return The field word with some hard brackets around it
     */
    public String toString(){
        return "["+word+"]";
    } 
}
