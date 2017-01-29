import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class EfficientMarkovModel extends AbstractMarkovModel{

	private int key_length;
	public EfficientMarkovModel(int input_length) {
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
		HashMap<String, ArrayList<String>> store_map = new HashMap<>();
		for (int idx = 0; idx < numChars - key_length; idx += 1)
		{
			ArrayList<String> follows = new ArrayList<>();
			if ( !store_map.containsKey(key))
			{
				follows = get_follows(key);
				store_map.put(key, follows);
			}
			else
			{
				follows =  store_map.get(key);
			}
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
