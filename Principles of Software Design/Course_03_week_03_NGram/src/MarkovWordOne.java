
/**
 * Write a description of class MarkovWordOne here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;

public class MarkovWordOne implements IMarkovModel {
    private String[] myText;
    private Random myRandom;
    
    public MarkovWordOne() {
        myRandom = new Random();
    }
    
    public void setRandom(int seed) {
        myRandom = new Random(seed);
    }
    
    public void setTraining(String text){
		myText = text.split("\\s+");
	}
	
	public String getRandomText(int numWords){
		StringBuilder sb = new StringBuilder();
		int index = myRandom.nextInt(myText.length-1);  // random word to start with
		String key = myText[index];
		sb.append(key);
		sb.append(" ");
		for(int k=0; k < numWords-1; k++){
		    ArrayList<String> follows = getFollows(key);
		    if (follows.size() == 0) {
		        break;
		    }
			index = myRandom.nextInt(follows.size());
			String next = follows.get(index);
			sb.append(next);
			sb.append(" ");
			key = next;
		}
		
		return sb.toString().trim();
	}
	
	private ArrayList<String> getFollows(String key) {
	    ArrayList<String> follows = new ArrayList<String>();
	    for (int idx = 0; idx < myText.length; idx += 1)
	    {
	    	String current_word = myText[idx];
	    	if ( current_word.equals(key))
	    	{
	    		String word_to_add = myText[idx+1];
	    		follows.add(word_to_add);
	    	}
	    			
	    }
	    return follows;
    }
	
	private int indexOf(String[] words, String target, int start)
	{
		for (int idx = start; idx < words.length; idx +=1)
		{
			String current_word = words[idx];
			if (current_word.equals(target))
			{
				return idx;
			}
		}
		return -1;	
	}
	
	public void testIndexof()
	{
		String test_string = "this is just a test yes this is a simple test";
		String[] test_string_array = test_string.split("\\s+");
		System.out.println(indexOf(test_string_array,"this",0) == 0);
		System.out.println(indexOf(test_string_array,"frog",0) == -1);
		System.out.println(indexOf(test_string_array,"yes",0) == 5);
		System.out.println(indexOf(test_string_array,"this",2) == 6);
	}

}