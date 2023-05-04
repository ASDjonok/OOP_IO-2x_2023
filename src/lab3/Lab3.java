package lab3;

public class Lab3 {
    private static final int REPETITION_NUMBER = 10;
    public static void main(String[] args) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < REPETITION_NUMBER; i++) {
//            result += Integer.toString(i);
//            result += String.valueOf(i);
            result.append(i);
        }



        /*float f = 1.1f;
        double d = 2.2;
//        f = (float) (f + d);
        f += d;*/

        String s = "ASD";

        StringBuilder stringBuilder = new StringBuilder("ASD");
        StringBuffer stringBuffer = new StringBuffer("ASD");

        stringBuilder.append("A");
        System.out.println(s.length());
        System.out.println(stringBuilder.length());
        System.out.println(stringBuffer.length());

        System.out.println(s.endsWith("D"));
//        System.out.println(stringBuilder.substring(stringBuilder.length() - 1).equals("A"));
        System.out.println("A".equals(stringBuilder.substring(stringBuilder.length() - 1)));
        System.out.println("A".equals(stringBuffer.substring(stringBuffer.length() - 1)));

        String sNull = null;
        System.out.println("A".equals(sNull));
        System.out.println(sNull.equals("A"));

        System.out.println(s.substring(2));
        System.out.println(s.contains("AS"));

        System.out.println(s.indexOf('a'));

//        System.out.println(s.charAt(-1));

        System.out.println("s.equalsIgnoreCase(\"AsD\") = " + s.equalsIgnoreCase("AsD"));

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
//        String s5 = new String("ASD");
        String s5 = "AS";
        s5 += "D";
        System.out.println(s4 == s5); // true? (SP)
        System.out.println(s4.equals(s5)); // (true)



        System.out.println("Done!");
    }
}
