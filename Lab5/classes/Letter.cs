using System;

namespace classes
{
    class Letter
    {
        private char letter;
        public Letter(char c)
        {
            letter = c;
        }

        public string getElement()
        {
            return ""+ letter;
        }
        public char getLetter()
        {
            return letter;
        }
    }
}