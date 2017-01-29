
/**
 * Abstract class AbstractMarkovModel - write a description of the class here
 * 
 * @author (your name here)
 * @version (version number or date here)
 */

import java.util.*;

public abstract class AbstractMarkovModel implements IMarkovModel {
    protected String myText;
    protected Random myRandom;
    
    public AbstractMarkovModel() {
        myRandom = new Random();
    }
    
    public void setTraining(String s) {
        myText = s.trim();
    }
 
    abstract public String getRandomText(int numChars);
    
	public ArrayList<String> get_follows(String key)
	{
		int total_length = myText.length();
		int key_length = key.length();
		int word_length = 1;
		ArrayList<String> follow_array = new ArrayList<>();
		for (int idx = 0; idx < total_length - key_length - word_length + 1; idx += 1)
		{
			String current_word = myText.substring(idx, idx+key_length);
			if (current_word.equals(key))
			{
				String word_to_add = myText.substring(idx+key_length, idx+key_length+word_length);
				follow_array.add(word_to_add);
			}
		}
//		System.out.println(follow_array.size());
		return follow_array;
	}

}
