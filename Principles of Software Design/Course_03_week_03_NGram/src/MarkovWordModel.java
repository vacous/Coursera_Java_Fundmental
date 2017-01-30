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
		HashMap<String, ArrayList<String>> store_map = new HashMap<>();
		for (int idx = 0; idx < numWords - order; idx += 1)
		{
			ArrayList<String> current_follows = new ArrayList<>();
			String key_in_string = key.toString();
//			System.out.println(key_in_string);
			if (!store_map.containsKey(key_in_string))
			{
				current_follows = getFollows(key);
				store_map.put(key_in_string, current_follows);
			}
			else
			{
				current_follows = store_map.get(key_in_string);
			}
			if (current_follows.size() == 0)
			{
				break;
			}
			index = myRandom.nextInt(current_follows.size());
			String next_word = current_follows.get(index);
			sb.append(next_word);
			sb.append(" ");
			key = key.shift_add(next_word);
		}
//		for (String each_key_string: store_map.keySet())
//		{
//			System.out.println(each_key_string);
//			System.out.println("----------");
//			for (String each_word: store_map.get(each_key_string))
//			{
//				System.out.println(each_word);
//			}
//			System.out.println("===================================");
//		}
		return sb.toString().trim();
	}
	
	private void string_builder_with_word_gram(StringBuilder input_sb, WordGram word_to_add)
	{
		for (int idx = 0; idx < word_to_add.length(); idx +=1)
		{
			input_sb.append(word_to_add.wordAt(idx));
			input_sb.append(" ");
		}
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
