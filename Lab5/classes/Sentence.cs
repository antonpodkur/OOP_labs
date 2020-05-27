using System;
using System.Text;

namespace classes
{
    class Sentence: Element
    {
        string[] arr;
        Word[] word_arr;
        private Element[] arr_sentence;
        public Sentence(Element[] arr_sentence)
        {
            this.arr_sentence = arr_sentence; 
        }
        public string getElement()
        {
            string sentence = "";
            for (int i =0; i<arr_sentence.Length;i++)
            {
                if(arr_sentence[i].getType()=="word" && arr_sentence[i+1].getType()=="word")
                {
                    sentence+=arr_sentence[i].getElement()+" ";
                }
                else sentence+=arr_sentence[i].getElement();
            }
            return sentence;
        }
        
        public string getType()
        {
            return "sentence";
        }
        
        public Word[] brake()
        {
            word_arr=new Word[arr_sentence.Length];
            int counter =0;
            for(int i=0;i<arr_sentence.Length;i++)
            {
                if(arr_sentence[i].getType()=="word")
                {
                    word_arr[counter]=new Word(arr_sentence[i].getElement());
                    counter++;
                }
            }
            return word_arr;
        }
        public  override string ToString()
        {
            string sentence = "";
            for (int i =0; i<arr_sentence.Length;i++)
            {
                if(arr_sentence[i].getType()=="word" && arr_sentence[i+1].getType()=="word")
                {
                    sentence+=arr_sentence[i].getElement()+" ";
                }
                else sentence+=arr_sentence[i].getElement();
            }
            return sentence;
        }
    }
}