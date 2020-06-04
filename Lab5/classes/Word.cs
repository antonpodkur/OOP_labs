using System;
using System.Text;

namespace classes
{
    class Word: Element
    {
        private Letter[] arr_word; 
        private string str_word="";

        private int amount_of_loud_sounds=0;
        private char[] mass ={'e','y','u','i','o','a','E','Y','U','I','O','A'};
        public Word(Letter[] word)
        {
            arr_word = word;

            foreach (Letter l in arr_word)
            {
                str_word +=l.getElement();
            }
        }
        
        public string getElement()
        {
            return str_word;
        }

        public  override string ToString()
        {
                return str_word;
        }
        public string getType()
        {
            return "word";
        }

        public int get_amount_of_loud_sounds()
        {
            // for(int i=0;i<arr_word.Length;i++)
            // {
            //     Console.WriteLine(arr_word[i].getElement());
            // }
            // return 1;
            amount_of_loud_sounds=0;
            foreach(var l in arr_word)
            {
                foreach(var m in mass)
                {
                    if(l.getLetter()==m) amount_of_loud_sounds++;
                }
            }
            return amount_of_loud_sounds;
        }
       
    }
}