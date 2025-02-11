import java.util.ArrayList;

public class ALUTIL
{
   /**
      Removes adjacent duplicates from an array list of strings.
      @param words an array list of strings
   */
   public static void removeAdjacentDuplicates(ArrayList<String> words)
   {
      String currentWord;
      String nextWord;
      for (int j = 0; j < words.size(); ++j) {
         for (int i = 0; i < words.size(); ++i) {
            currentWord = words.get(i);
            try {
               nextWord = words.get(i + 1);
            } catch (Exception e) {
               break;
            }
            if (currentWord.equals(nextWord)) {
               words.remove(i);
            }
         }
      }
   }
}