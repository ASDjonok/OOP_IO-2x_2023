﻿using System;
using System.Collections.Generic;

class Lab3
{
    public static void Main(string[] args)
    {
        string text = "Вухатий великий синiй слон. Яблуко в саду. Зелене яблуко? Груша. Жовта слива висить у саду!";
        Console.WriteLine(text );

        // розділяємо текст на окремі речення
        string[] textSplit = text.Split(new[] { '.', '?', '!' }, StringSplitOptions.RemoveEmptyEntries);

        // обчислюємо кількість слів у кожному реченні та створюємо масив з кількістю слів у реченнях
        int[] amountOfWords = new int[textSplit.Length];
        for (int i = 0; i < textSplit.Length; i++)
        {
            string[] words = textSplit[i].Trim().Split(' ');
            amountOfWords[i] = words.Length;
        }

        // створюємо Dictionary, де ключ - кількість слів у реченні, а значення - речення
        Dictionary<int, string> sentenceDictionary = new Dictionary<int, string>();
        for (int i = 0; i < textSplit.Length; i++)
        {
            sentenceDictionary.Add(amountOfWords[i], textSplit[i]);
        }
        var sortedDict = sentenceDictionary.OrderBy(x => x.Key).ToDictionary(x => x.Value, x => x.Key);


        Console.WriteLine(String.Join(";", sortedDict.Keys));
    }
}
