/*
    Write a specific in JML that gives sense to the method, given the following example:
    - text = [abbcdddeff], chunk = [bcddd] -> returns true
    - text = [abbcdddeff], chunk = [baadd] -> returns false
*/

import java.util.Arrays;

public class SubString {
    // Since chunk is a substring of text, we can say that chunk.legth must be equal or lower then text.length
    // We clearly don't want null parameters
    // The method returns true only if chunk is sub string of text

    /*@ requires text != null && chunk != null  && chunk.length <= text.length;
     ensures (\exists int i; i >= 0 && i < text.length;
                 (\forall int j; j >= 0 && j < chunk.length; text[j+i] == chunk[j])
             ) <==> \result == true;

     @*/
    public static boolean subString(char[] text, char[] chunk) {
        String _text = Arrays.toString(text);
        String _chunk = Arrays.toString(chunk);
        return _text.contains(_chunk);
    }

    /*@
     ensures (\exists int i; i >= 0 && i < text.length;
                (\forall int j; j >= 0 && j < chunk.length; text[j+i] == chunk[j])
             ) <==> \result == true;
    signals (NullPointerException npe) (text == null || chunk == null);
    @*/
    public static boolean subStringE(char[] text, char[] chunk) throws NullPointerException {
        if (text == null || chunk == null)
            throw new NullPointerException();
        boolean result;
        String _text = Arrays.toString(text);
        String _chunk = Arrays.toString(chunk);
        result = _text.contains(_chunk);
        return result;
    }


}