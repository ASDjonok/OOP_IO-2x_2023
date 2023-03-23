using System;

public class Lab1
{
    public static void Main(String[] args)
    {
        /*o1 = +
         c3 = 0
         o2 = *
         c7 = short */

         var A = 4;
         short B = 3;
         var N = 10;
         var M = 10;

         var C = 1;
         var s = 0;

         bool divisionByZero=false;


        if ((A <= -C && -C <= N) || (B <= 0 && 0 <= M))
        {
            Console.WriteLine("Division by zero!");
            return;
        }
      
        for (int i = A; i <= N; i++)
        {
            if (i + C == 0) { 
                Console.WriteLine("Division by zero!");
                divisionByZero = true;
                break; 
            }
            for (short j = B; j <= M; j++)
            {
                if (j == 0) {
                    Console.WriteLine("Оскільки j = 0, то сума просто буде 0");
                    break;
                }
                s += (i * j) / (i + C);
            }
        }

        if (!divisionByZero)
        {
            Console.WriteLine($"s = {s};" );
        }

    }
}
