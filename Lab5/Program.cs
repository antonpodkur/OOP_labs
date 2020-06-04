using System;
using classes;
using System.Collections.Generic;
using System.Linq;

namespace Lab5
{
    class Program
    {
        static void Main(string[] args)
        {
        
        //string temp;
        Letter[] letters1 = {
            new Letter('T'),
            new Letter('h'),
            new Letter('i'),
            new Letter('s'),
        };

        Letter[] letters2 = {
            new Letter('i'),
            new Letter('s'),
        };

        Letter[] letters3 = {
            new Letter('a'),
        };
        Letter[] letters4 = {
            new Letter('t'),
            new Letter('e'),
            new Letter('s'),
            new Letter('t'),
        };
        Letter[] letters5 = {
            new Letter('s'),
            new Letter('e'),
            new Letter('n'),
            new Letter('t'),
            new Letter('e'),
            new Letter('n'),
            new Letter('c'),
            new Letter('e'),
        };
        Symbols symb = new Symbols(".");

        Word word1 = new Word(letters1);
        Word word2 = new Word(letters2);
        Word word3 = new Word(letters3);
        Word word4 = new Word(letters4);
        Word word5 = new Word(letters5);

        Sentence sentence = new Sentence(new Element[]{word1,word2,word3,word4,word5,symb});
        Console.WriteLine(sentence);

        Word[] arr = sentence.brake();

        List<Word> arr2 = new List<Word>();
        for(int i=0;i<arr.Length-1;i++)
        {
            arr2.Add(arr[i]);
        }
        List<Word> sorted = arr2.OrderBy(x => x.get_amount_of_loud_sounds()).ToList();
        sorted.Reverse();
        foreach(var r in sorted)
        {
            Console.WriteLine(r+" - "+r.get_amount_of_loud_sounds());
        }
		}
    }
}       
    

