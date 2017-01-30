import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

import javax.print.attribute.HashPrintServiceAttributeSet;

import edu.duke.StorageResource;

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
		
		HashMap<String, ArrayList<String>> store_map = map_builder();
		for (int idx = 0; idx < numChars - key_length; idx += 1)
		{
			ArrayList<String> current_follows = store_map.get(key);
			if (current_follows == null)
			{
				break;
			}
			index = myRandom.nextInt(current_follows.size());
			String next_char = current_follows.get(index);
			sb.append(next_char);
			key = key.substring(1) + next_char;
//			System.out.println(key);
//			System.out.println(sb.toString());
//			System.out.println("---------------");
 		}
		return sb.toString();
	}
	
	public HashMap<String, ArrayList<String>> map_builder()
	{
		HashMap<String, ArrayList<String>> store_map = new HashMap<>();
		for (int idx = 0; idx < myText.length() - key_length; idx += 1)
		{
			String current_key = myText.substring(idx, idx + key_length);
			ArrayList<String> follows = get_follows(current_key);
			if (!store_map.containsKey(current_key))
			{
				store_map.put(current_key, follows);
			}
			System.out.println(idx + "|" + myText.length() + "|" + store_map.size());
 		}
		String tail_string = myText.substring(myText.length()-key_length);
		store_map.put(tail_string, null);
		System.out.println("The HashMap size is: " + store_map.size());
		System.out.println("The largest length: " + largest_size(store_map));
//		System.out.println(store_map.keySet());
		return store_map;
	}
	
	private int largest_size(HashMap<String, ArrayList<String>> input_map)
	{
		int max_len = 0;
		for (String each_key: input_map.keySet())
		{
			ArrayList<String> current_array = input_map.get(each_key);
			int current_length = 0;
			if ( current_array != null)
			{
				current_length = current_array.size();
			}
			if ( current_length > max_len )
			{
				max_len = current_length;
			}
		}
		return max_len;
	}
}
