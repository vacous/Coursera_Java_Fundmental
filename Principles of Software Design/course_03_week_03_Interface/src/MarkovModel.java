import java.util.ArrayList;
import java.util.Random;

public class MarkovModel extends AbstractMarkovModel{

	private int key_length;
	public MarkovModel(int input_length) {
		key_length = input_length;
		myRandom = new Random();
	}
	
	public void setRandom(int seed){
		myRandom = new Random(seed);
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

}
