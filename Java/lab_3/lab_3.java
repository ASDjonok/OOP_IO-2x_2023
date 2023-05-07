package OOP.Java.lab_3;

public class lab_3 {
    static int maxStrLength;
    static String result;
    
    public static void cSubUtil(StringBuilder stringbuilder, int leftBoundary, int rightBoundary) {
        String string = stringbuilder.toString().toLowerCase().replaceAll("[^a-z]","");
        // check if the indices lie in the range of string
        // and also if it is palindrome
        while (leftBoundary >= 0 && rightBoundary < string.length() && string.toLowerCase().charAt(leftBoundary) == string.toLowerCase().charAt(rightBoundary)) {
            // expand the boundary
            leftBoundary--;
            rightBoundary++;
        }
        // if it's length is greater than maxLength update
        // maxLength and res
        if (rightBoundary - leftBoundary - 1 >= maxStrLength) {
            result = string.substring(leftBoundary + 1, rightBoundary);
            maxStrLength = rightBoundary - leftBoundary - 1;
        }
        return;
    }

    public static int longestPalSubstr(StringBuilder string)
    {
        result = "";
        maxStrLength = 1;
        // for every index in the string check palindromes
        // starting from that index
        for (int i = 0; i < string.length(); i++) {
            // check for odd length palindromes
            cSubUtil(string, i, i);
            // check for even length palindromes
            cSubUtil(string, i, i + 1);
        }
        System.out.println("Longest palindrome substring is: " + compareStrings(string));
        return compareStrings(string).length();
    }

    public static String compareStrings(StringBuilder builder) {
        for (int leftBoundary = 0; leftBoundary <= builder.length(); leftBoundary++) {
            for (int rightBoundary = builder.length(); leftBoundary >= 0; rightBoundary--) {
                if (result.equals(builder.substring(leftBoundary, rightBoundary).toString().toLowerCase().replaceAll("[^a-z]",""))) {
                    return builder.substring(leftBoundary, rightBoundary).toString();
                }
            }
        }
        return "";
    }

    public static void main(String[] args) {
        StringBuilder stringToDetect = new StringBuilder("Eva, can I see bees in a cave?");

        System.out.println("Initial string: " + stringToDetect.toString());
        System.out.println("Length is: " + longestPalSubstr(stringToDetect));
    }
}
