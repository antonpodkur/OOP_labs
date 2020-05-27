using System;

namespace classes
{
    class Symbols: Element
    {
        private string symbols;
        public Symbols(string symbols)
        {
            this.symbols = symbols;
        }

        public string getElement()
        {
            return symbols;
        }
        public  override string ToString()
        {
            return symbols;
        }
        public string getType()
        {
            return "symbol";
        }
    }
}