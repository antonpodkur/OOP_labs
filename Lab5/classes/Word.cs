using System;
using System.Text;

namespace classes
{
    class Word: Element
    {
        private Letter[] arr_word; 
        private string str_word;
        public Word(Letter[] word)
        {
            arr_word = word;
        }
        public Word(string word)
        {
            str_word = word;
        }
        
        public string getElement()
        {
            string word="";
            foreach (Letter l in arr_word)
            {
                word +=l.getElement();
            }
            return word;
        }
        public  override string ToString()
        {
                return str_word;
        }
        public string getType()
        {
            return "word";
        }
        public string toWordEditor()
        {
            return str_word;
        }
    }
}