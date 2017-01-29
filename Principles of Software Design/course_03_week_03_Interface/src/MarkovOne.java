import java.util.ArrayList;
import java.util.Random;

public class MarkovOne extends AbstractMarkovModel{

	public void setRandom(int seed){
		myRandom = new Random(seed);
	}
	
	public String getRandomText(int numChars){
		int key_length = 1;
		StringBuilder sb = new StringBuilder();
		int index = myRandom.nextInt(myText.length() - key_length);
		String key = myText.substring(index, index + key_length);
		sb.append(key);
		
		for (int idx = 0; idx < numChars - key_length; idx += 1)
		{
			ArrayList<String> follows = get_follows(key);
//			System.out.println("key" + key + " " + follows);
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
