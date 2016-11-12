public class Main {

    public static String convert(String s, int numRows) {
        String retVal = "";
        String[] rows = new String[numRows];
        for (int j = 0; j < numRows; j++) {
            rows[j] = "";
        }

        int i = 0;
        int strLen = s.length();

        while ( i < strLen ) {

            for (int j = 0; j < numRows &&  i < strLen; j++) {
                rows[j] += s.charAt(i);
                i++;
            }

            for (int j = numRows - 2; j >= 1 &&  i < strLen; j--) {
                rows[j] += s.charAt(i);
                i++;
            }
        }

        for (int j = 0; j < numRows; j++) {
            retVal += rows[j];
        }

        return retVal;
    }

    public static void main(String[] args) {
        System.out.println(convert("", 1));
    }
}
