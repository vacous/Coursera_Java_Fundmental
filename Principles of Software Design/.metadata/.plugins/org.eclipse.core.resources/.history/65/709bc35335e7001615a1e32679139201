import java.util.ArrayList;
import java.util.Random;

public class MarkovModel {
    private String myText;
	private Random myRandom;
	private int key_length;
	public MarkovModel(int input_length) {
		key_length = input_length;
		myRandom = new Random();
	}
	
	public void setRandom(int seed){
		myRandom = new Random(seed);
	}
	
	public void setTraining(String s){
		myText = s.trim();
	}
	
	public String getRandomText(int numChars){
		StringBuilder sb = new StringBuilder();
		int index = myRandom.nextInt(myText.length() - key_length);
		String key = myText.substring(index, index + key_length);
		sb.append(key);
		
		for (int idx = 0; idx < numChars - key_length; idx += 1)
		{
			ArrayList<String> follows = get_follows(key);
			if ( follows.size() == 0)
				break;
			index = myRandom.nextInt(follows.size());
			String next = follows.get(index);
			sb.append(next);
			key = key.substring(1) + next; 
		}
		return sb.toString();
	}
	
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
