import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.function.DoubleToLongFunction;

public class DataAnalyzer {
	RaterDatabase myRaterDatabase;
	MovieDatabase myMovieDatabase;
	HashMap<String, HashMap<String, Rater>> myMovieRatingMap;
	public DataAnalyzer(RaterDatabase input_rater, MovieDatabase input_movie)
	{
		myRaterDatabase = input_rater;
		myMovieDatabase = input_movie;
		myMovieRatingMap = RaterDatabase.getMovieRatingMap();
	}
	
	
	public double getAverageByID(String movie_id, int minimalRaters)
	{
		HashMap<String, Rater> name_rater_map = myMovieRatingMap.get(movie_id);
		if(name_rater_map.size() >= minimalRaters)
		{
			double total_rating = 0;
			int counter = 0;
			for(Rater each_rater: name_rater_map.values())
			{
				total_rating += each_rater.getRating(movie_id);
				counter += 1;
			}
			return total_rating/counter;
		}
		return 0;
	}
	
	
	public ArrayList<Rating> getAverageRatings(int minimalRate)
	{	
		ArrayList<Rating> all_satisfied_movie = new ArrayList<>();
		for(String each_movie: myMovieRatingMap.keySet())
		{
			if(myMovieRatingMap.get(each_movie).size() >= minimalRate)
			{
				double each_avg_rating = getAverageByID(each_movie, minimalRate);
				Rating each_to_add = new Rating(each_movie, each_avg_rating);
				all_satisfied_movie.add(each_to_add);
			}
		}
		return all_satisfied_movie;
	}
	
	public ArrayList<Rating> getAverageRatingsWithFilter(int minimalRate, Filter input_filters)
	{
		ArrayList<Rating> all_satisfied_movie = new ArrayList<>();
		ArrayList<String> filtered_movie = MovieDatabase.filterBy(input_filters);

		for(String each_movie: filtered_movie)
		{	
			if(myMovieRatingMap.containsKey(each_movie) && 
					myMovieRatingMap.get(each_movie).size() >= minimalRate)
			{
				double each_avg_rating = getAverageByID(each_movie, minimalRate);
				Rating each_to_add = new Rating(each_movie, each_avg_rating);
				all_satisfied_movie.add(each_to_add);
			}
		}
		return all_satisfied_movie;
	}
	
	private double dotProduct(Rater rater_01, Rater rater_02)
	{
		Set<String> all_same_movies = new HashSet<String>(rater_01.getItemsRated());
		Set<String> movies_02 = new HashSet<>(rater_02.getItemsRated());
		all_same_movies.retainAll(movies_02);
		double total_product = 0;
		int offset = 5;
		for(String each_movie: all_same_movies)
		{
			total_product += (rater_01.getRating(each_movie) - offset) *
					(rater_02.getRating(each_movie) - offset);
		}
		return total_product;
	}
	
	
	private ArrayList<Rating> getSimilarities(String name_id)
	{
		Rater main_rater = RaterDatabase.getRater(name_id);
		
		ArrayList<Rater> all_raters = RaterDatabase.getRaters();
		ArrayList<Rating> rating_list = new ArrayList<>();
		for(Rater each_rater: all_raters)
		{
			double product = dotProduct(main_rater, each_rater);
			// only those not main_rater and product larger than 0
			if(!each_rater.equals(main_rater) && product > 0)
			{
				rating_list.add(new Rating(each_rater.getID(), dotProduct(main_rater, each_rater)));
			}	
		}
		Collections.sort(rating_list, Collections.reverseOrder());
		return rating_list;
	}
	
	public ArrayList<Rating> getSimilarRatings(String name_id, int numSimilarRaters, int minimalRaters)
	{
		Iterable<Rating> weight_list = getSimilarities(name_id).subList(0, numSimilarRaters);
		HashMap<String, multipleRating> weighted_map = new HashMap<>();
		for(Rating each_rater: weight_list)
		{
			double current_weight = each_rater.getValue();
			Rater current_rater = RaterDatabase.getRater(each_rater.getItem());
			ArrayList<Rating> all_rated_movie = current_rater.getAllRating();
			for(Rating each_rated_movie: all_rated_movie)
			{
				String current_movie_id = each_rated_movie.getItem();
				if(!weighted_map.containsKey(current_movie_id))
				{
					multipleRating to_mod = new multipleRating(current_movie_id, each_rated_movie.getValue() * current_weight);
					weighted_map.put(current_movie_id, to_mod);
				}
				else
				{
					multipleRating to_mod = weighted_map.get(current_movie_id);
					to_mod.addValue(each_rated_movie.getValue() * current_weight);
					weighted_map.put(current_movie_id, to_mod);
				}
			}
		}
		// only those with at least minimalRaters 
		Collection<multipleRating> all_rating = weighted_map.values();
		ArrayList<Rating> output_array = new ArrayList<>();
		for(multipleRating each_weight_rating: all_rating)
		{
			if(each_weight_rating.getRatingNum() >= minimalRaters)
			{
				output_array.add(new Rating(each_weight_rating.getItem(), each_weight_rating.getAverage()));
			}
		}
		Collections.sort(output_array, Collections.reverseOrder());
		return output_array;
	}
	
	public ArrayList<Rating> getSimilarRatingbyFilters(String name_id, int numSimilarRaters, int minimalRaters, Filter input_filters)
	{
		ArrayList<Rating> all_pre_ratings = getSimilarRatings(name_id, numSimilarRaters, minimalRaters);
		ArrayList<Rating> all_satisfy_rating = new ArrayList<>();
		for(Rating each_rating: all_pre_ratings)
		{
			String current_id = each_rating.getItem();
			if(input_filters.satisfies(current_id))
			{
				all_satisfy_rating.add(each_rating);
			}
		}
		return all_satisfy_rating;
	}
}
