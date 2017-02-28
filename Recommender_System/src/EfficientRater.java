import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

public class EfficientRater implements Rater{
	private String myID;
	private HashMap<String, Rating> myRatingMap = new HashMap<>();
	public EfficientRater(String input_id) {
		myID = input_id;
	}
	
	
	@Override
	public void addRating(String item, double rating) {
		Rating replace = new Rating(item, rating);
		if(myRatingMap.containsKey(item))
		{
			System.out.println("Rating conflict: " + item);
		}
		else
		{
			myRatingMap.put(item, replace);
		}
	}

	@Override
	public boolean hasRating(String item) {
		return myRatingMap.containsKey(item);
	}

	@Override
	public String getID() {
		return myID;
	}

	@Override
	public double getRating(String item) {
		return myRatingMap.get(item).getValue();
	}

	@Override
	public int numRatings() {
		return myRatingMap.size();
	}

	@Override
	public ArrayList<String> getItemsRated() {
		ArrayList<String> rated_items = new ArrayList<>();
		for(String each_item: myRatingMap.keySet())
		{
			rated_items.add(each_item);
		}
		return rated_items;
	}

	@Override
	public ArrayList<Rating> getAllRating() {
		Collection<Rating> all_ratings = myRatingMap.values();
		ArrayList<Rating> output_ratings = new ArrayList<>();
		for(Rating each: all_ratings)
		{
			output_ratings.add(each);
		}
		return output_ratings;
	}
	
	
	public int hashCode()
	{
		return Integer.parseInt(myID);
	}
	
	public boolean equals(Object other_object)
	{	
		if(this.getClass() == other_object.getClass())
		{
			return this.hashCode() == other_object.hashCode();
		}
		return false;
	}
	
	public String toString()
	{
		return myRatingMap.keySet().toString();
	}

}
