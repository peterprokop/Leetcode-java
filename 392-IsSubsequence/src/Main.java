import java.util.ArrayList;

public class Main {

    public static boolean helper(String s, String t, int startIndex) {
        int substringLength = s.length();
        int stringLength = t.length();

        int i = 0;

        for (int j = startIndex; j < stringLength; j++) {
            if ( s.charAt(i) == t.charAt(j) ) {
                i++;
            }

            if ( i == substringLength ) {
                return true;
            }

        }

        return false;
    }

    public static boolean isSubsequence(String s, String t) {
        int substringLength = s.length();
        int stringLength = t.length();

        if ( substringLength == 0) { return true; }

        ArrayList<Integer> firstLetterIndexes = new ArrayList<Integer>();
        for ( int i = 0; i < stringLength ; i++) {
            if ( t.charAt(i) == s.charAt(0) ) {
                firstLetterIndexes.add(i);
            }
        }

        for ( int i : firstLetterIndexes ) {
            if ( helper(s, t, i) ) { return true;}
        }


        return false;

    }

    public static void main(String[] args) {
	    System.out.println("" + isSubsequence("adij", "abcdefghij"));
        System.out.println("" + isSubsequence("adji", "abcdefghij"));
    }
}
