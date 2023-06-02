using System;

public class Laba2
{
    public static void Main(string[] args)
    {
        const int a = 2;
        int[,] b = new[,] //створення матриці;
        {
             { 1, 2, 8 },
             { 3, 4, 5 },
             { 6, 7, 9 }
        };
        int rows = b.GetLength(0); //отримання довжини рядків
        int cols = b.GetLength(1); //отримання довжини стовпців
       for (int i = 0; i < rows; i++) 
        {
            int Avg = 0;
            for (int j = 0; j < cols; j++)
            {
                Console.Write(b[i, j] + " ");      // перебір матриці для обчислення середнього значення рядка
                Avg += b[i, j];
            }
            Avg = Avg / cols;
            Console.Write($"-average of row is:{Avg};"  );
            Console.WriteLine(" ");
          
        }
       Console.WriteLine(" ");
       for (int x = 0; x < rows; x++)
       {
           for (int y = 0; y < cols; y++)
           {
               Console.Write(b[x, y] * a + " "); //виведення матриці, помноженої на константу

           }
           Console.WriteLine(" ");
       }
    }
}
