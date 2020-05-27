using System;

namespace classes
{
    class WordEditor
    {
        private string word;
        private char[] lastarrey;
        private int amount_of_loud_sounds=0;
        private char[] mass ={'e','y','u','i','o','a','E','Y','U','I','O','A'};
        public WordEditor(string s)
        {
            word=s;
            lastarrey=new char[word.Length];
            for(int i=0;i<word.Length;i++)
            {
                lastarrey[i] = word[i];
            }
            for(int i=0;i<word.Length;i++)
            {
                for(int j=0;j<mass.Length;j++)
                {
                    if (lastarrey[i]==mass[j]) amount_of_loud_sounds++;
                }
            }            
        }
        public int get_amount_of_loud_sounds()
        {
            return amount_of_loud_sounds;
        }
        public override string ToString()
        {
            return word;
        }
    }
}