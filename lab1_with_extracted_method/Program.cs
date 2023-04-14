using System;

public class Lab1
{
    public static void Main(String[] args)
    {
        /*o1 = +
         c3 = 0
         o2 = *
         c7 = short */
    

        calculation(4, 3, 10, 10, 11, false);
    }

    public static void calculation(int A, int C, int N, short B, int M, bool divisionByZero)
    {
        double s = 0;
        if (A <= -C && -C <= N)
        {
            Console.WriteLine("Division by zero!");
            return;
        }

        for (int i = A; i <= N; i++)
        {
           

            for (short j = B; j <= M; j++)
            {
                if (j == 0)
                {
                    Console.WriteLine("Оскільки j = 0, то сума просто буде 0");
                    break;
                }

                s +=(double)(i * j) / (i + C);
            }
        }

        if (!divisionByZero)
        {
            Console.WriteLine($"s = {s};");
        }
    }
}
