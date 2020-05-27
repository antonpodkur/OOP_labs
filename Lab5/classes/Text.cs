using System;


namespace classes
{
    class Text
    {
        private Sentence[] arr_text;

        public Text(Sentence[] arr_text)
        {
            this.arr_text = arr_text;
        }
        public string getElement()
        {
            string text = "";
            for (int i =0; i<arr_text.Length;i++)
            {
                if(arr_text[i].getType()=="word" && arr_text[i+1].getType()=="word")
                {
                    text+=arr_text[i].getElement()+" ";
                }
                else text+=arr_text[i].getElement();
            }
            return text;
        }
        public  override string ToString()
        {
            string text = "";
            for (int i =0; i<arr_text.Length;i++)
            {
                if(arr_text[i].getType()=="sentence" && arr_text[i+1].getType()=="sentence")
                {
                    text+=arr_text[i].getElement()+" ";
                }
                else text+=arr_text[i].getElement();
            }
            return text;
        }
    }
}