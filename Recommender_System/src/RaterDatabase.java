
/**
 * Write a description of RaterDatabase here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;
import java.util.*;
import org.apache.commons.csv.*;

public class RaterDatabase {
    private static HashMap<String,Rater> ourRaters;
    private static HashMap<String, HashMap<String, Rater>> ourRatingMap; 
	private static void initialize() {
	    // this method is only called from addRatings 
		if (ourRaters == null) {
			ourRaters = new HashMap<String,Rater>();
			ourRatingMap = new HashMap<>();
		}
	}

    public static void initialize(String filename) {
 		if (ourRaters == null) {
 			ourRaters= new HashMap<String,Rater>();
 			ourRatingMap = new HashMap<>();
 			addRatings("data/" + filename);
 		}
 	}	
 	
    public static void addRatings(String filename) {
        initialize(); 
        FileResource fr = new FileResource(filename);
        CSVParser csvp = fr.getCSVParser(); 
        for(CSVRecord rec : csvp) {
                String id = rec.get("rater_id");
                String item = rec.get("movie_id");
                String rating = rec.get("rating");
                double rating_double = Double.parseDouble(rating);
                addRaterRating(id,item,rating_double);
                addMovieRater(item, id, rating_double);  
        }  
//        for(String each: ourRatingMap.keySet())
//        {
//        	System.out.println(each + " : " +ourRatingMap.get(each));
//        }
    }
    
    public static void addRaterRating(String raterID, String movieID, double rating) {
    	initialize(); 
    	Rater rater =  null;
    	if (ourRaters.containsKey(raterID)) {
    		rater = ourRaters.get(raterID); 
    	} 
    	else { 
    		rater = new EfficientRater(raterID);
    		ourRaters.put(raterID,rater);
    	}
    	rater.addRating(movieID,rating);
    } 
    
    
    public static void addMovieRater(String movieID, String raterID, double rating)
    {
    	initialize();
    	HashMap<String, Rater> to_add_map = new HashMap<>();  	
    	if(!ourRatingMap.containsKey(movieID))
    	{
    		Rater to_add_rater = new EfficientRater(raterID);
    		to_add_rater.addRating(movieID, rating);
    		to_add_map.put(raterID, to_add_rater);
    	}
    	else
    	{
    		to_add_map = ourRatingMap.get(movieID);
    		// check if the rater is recorded for this movie
    		Rater replace_rater = null;
    		if(to_add_map.containsKey(raterID))
    		{
    			replace_rater = to_add_map.get(raterID);
    		}
    		else
    		{
    			replace_rater = new EfficientRater(raterID);
    			to_add_map.put(raterID, replace_rater);
    		}
    		replace_rater.addRating(movieID, rating);
    	}
    	ourRatingMap.put(movieID, to_add_map);
    }
	         
    public static Rater getRater(String id) {
    	initialize();
    	
    	return ourRaters.get(id);
    }
    
    public static ArrayList<Rater> getRaters() {
    	initialize();
    	ArrayList<Rater> list = new ArrayList<Rater>(ourRaters.values());
    	
    	return list;
    }
 
    public static int size() {
	    return ourRaters.size();
    }
    
    public static HashMap<String, HashMap<String, Rater>> getMovieRatingMap()
    {
    	return ourRatingMap;
    }
    
        
}
