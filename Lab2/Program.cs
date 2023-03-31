using System;

public class Laba2
{
    

    public static void Main(string[] args)
    {
        const int a = 2;
        int[][] b = new[]
        {
            new int[] { 1, 2, 8 },
            new int[] { 3, 4, 5 },
            new int[] { 6, 7, 9 }
        };
        calculation(b, a);
    }

    private static int[][] calculation(int[][] b, int a)
    {
        int[][]c = new int[b.Length][b[0].Length]; //недопустимий специфікатор рангу: вимагається "," або "]";
        for (int i = 0; i < b.Length; i++)
        {
            c[i] = new int[b[i].Length];
            for (int j = 0; j < b[i].Length; j++)
            {
                c[i][j] = b[i][j] * a;
            }
        }
        return c;
    }
}