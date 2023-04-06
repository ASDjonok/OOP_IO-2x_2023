public class Lab3 {
    public static void main(String[] args) {
        String s = "ASD";
        String s2 = s;
        System.out.println("s2 = " + s2);
        System.out.println(s == s2); // true?
        System.out.println(s.equals(s2)); // true?
        s += "B";
        System.out.println(s);
        System.out.println("s2 = " + s2);

        System.out.println(s == s2); // false?
        System.out.println(s.equals(s2)); // false?

        String s3 = new String("ASD");
        System.out.println(s3 == s2); // true? (false)
        System.out.println(s3.equals(s2)); // false? (true)

//      String Pool
        String s4 = "ASD";
        System.out.println(s4 == s2); // true?
        System.out.println(s4.equals(s2)); // (true)

        System.out.println("Done!");
    }
}
