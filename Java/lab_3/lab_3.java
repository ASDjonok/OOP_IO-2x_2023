package OOP.Java.lab_3;

public class lab_3 {
    static int maxStrLength;
    static String result;

    /* public static StringBuilder StringBuilderLowerCase(StringBuilder pText) {
        StringBuilder pTextLower = new StringBuilder(pText);
        for (int idx = 0; idx < pText.length(); idx++) {
            char c = pText.charAt(idx);
            if (c >= 65 && c <= 65 + 27) {
                pTextLower.setCharAt(idx, (char) ((int) (pText.charAt(idx)) | 32));
            }
        }
        return pTextLower;
    } */
    
    static void cSubUtil(String string, int leftBoundary, int rightBoundary)
    {
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

    static int longestPalSubstr(String string)
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
        System.out.println("Longest palindrome substring is: " + result);
        return maxStrLength;
    }

    public static void main(String[] args) {
        StringBuilder stringToDetect = new StringBuilder("Eva, can I see bees in a cave?");
        String stripped = stringToDetect.toString().replaceAll("[\\.,:-\\?]? ?", "");

        System.out.println("Initial string: " + stringToDetect.toString());
        System.out.println("Length is: " + longestPalSubstr(stripped));
    }
}
