import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class MarkovWordModel implements IMarkovModel
{
    private String[] myText;
    private Random myRandom;
    private int order;

    
    public MarkovWordModel(int order_num) {
    	order = order_num;
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
		int index = myRandom.nextInt(myText.length-order);  // random word to start with
		WordGram key = new WordGram(myText, index, order);
		string_builder_with_word_gram(sb, key);
		HashMap<String, ArrayList<String>> store_map = map_builder();
		for (int idx = 0; idx < numWords - order; idx += 1)
		{
			String key_in_string = key.toString();
			ArrayList<String> current_follows = store_map.get(key_in_string);
			if ( current_follows.size() == 0)
			{
				break;
			}
			index = myRandom.nextInt(current_follows.size());
			String next_word = current_follows.get(index);
			sb.append(next_word);
			sb.append(" ");
			key = key.shift_add(next_word);
		}
		return sb.toString().trim();
	}
	
	private HashMap<String, ArrayList<String>> map_builder()
	{
		int total_len = myText.length;
		HashMap<String, ArrayList<String>> store_map = new HashMap<>();
		for (int idx = 0; idx < total_len - order + 1; idx += 1)
		{
			WordGram current_gram = new WordGram(myText, idx, order);
			String current_gram_str = current_gram.toString();
			ArrayList<String> current_follows =getFollows(current_gram);
			if ( !store_map.containsKey(current_gram_str))
			{
				store_map.put(current_gram_str, current_follows);
			}
		}
		System.out.println("The map size: " + store_map.size());
		System.out.println("The max follow size: " + largest_len(store_map));
		return store_map;
	}
	
	private int largest_len(HashMap<String, ArrayList<String>> input_map)
	{
		int max_len = 0;
		for (String each_key:input_map.keySet())
		{
			int current_len = input_map.get(each_key).size();
			if ( current_len > max_len )
			{
				max_len = current_len;
			}
		}
		return max_len;
	}
	
	
	
	private void string_builder_with_word_gram(StringBuilder input_sb, WordGram word_to_add)
	{
		input_sb.append(word_to_add.toString());
	}
	
	public ArrayList<String> getFollows(WordGram key) {
	    ArrayList<String> follows = new ArrayList<String>();
	    int total_length = myText.length;
	    for (int idx = 0; idx < total_length - order; idx += 1)
	    {
	    	WordGram current_word = new WordGram(myText, idx, order);	
	    	if (current_word.equals(key))
	    	{	
	    		String add_word = myText[idx + order];
	    		follows.add(add_word);
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
