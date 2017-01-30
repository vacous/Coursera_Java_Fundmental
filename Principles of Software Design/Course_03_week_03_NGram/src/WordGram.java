
public class WordGram {
	private String[] myWords;
	public WordGram(String[] source, int start, int size)
	{
		myWords = new String[size];
		System.arraycopy(source, start, myWords, 0, size);
	}
	
	public String wordAt(int index)
	{
		if (index<0 || index >= myWords.length)
		{
			throw new IndexOutOfBoundsException("bad index" + index);
		}
		return myWords[index];
	}
	
	public int length()
	{
		return myWords.length;
	}
	
	public boolean equals(Object input_o)
	{	
		WordGram compare_obj = (WordGram) input_o;
		int total_length = myWords.length;
		if ( compare_obj.length() != total_length)
		{
			return false;
		}
		for (int idx = 0; idx < total_length; idx += 1)
		{
			String current_word_01 = compare_obj.wordAt(idx);
			String current_word_02 = myWords[idx];
			if ( !current_word_01.equals(current_word_02) )
			{
				return false;
			}
		}
		return true;
	}
	
	public WordGram shift_add(String new_word)
	{	
		int array_len = this.myWords.length;
		String[] temp_words = new String[array_len + 1];
		System.arraycopy(this.myWords, 0, temp_words, 0, array_len);
		temp_words[array_len] = new_word;
		WordGram new_gram = new WordGram(temp_words,1,array_len);
		return new_gram;
	}
	
	public String toString()
	{
		String output_string = "";
		for (String each_string: myWords)
		{
			output_string += each_string + " ";
		}
		return output_string;
	}
}
