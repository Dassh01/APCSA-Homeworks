import java.util.Arrays;
import java.util.ArrayList;

public class TSTER
{
    public static void main(String[] args)
    {
        ArrayList<String> words1 = new ArrayList<String>(Arrays.asList(
                "Typing a a word twice is is a common mistake".split(" ")));
        ALUTIL.removeAdjacentDuplicates(words1);
        System.out.println(words1);
        System.out.println(
                "Expected: [Typing, a, word, twice, is, a, common, mistake]");
        ArrayList<String> words2 = new ArrayList<String>(Arrays.asList(
                "Typing a word three times is is is not so common".split(" ")));
        ALUTIL.removeAdjacentDuplicates(words2);
        System.out.println(words2);
        System.out.println(
                "Expected: [Typing, a, word, three, times, is, not, so, common]");
    }
}