import java.util.*;
import org.apache.commons.csv.*;
import edu.duke.FileResource;

public class MovieDatabase {
    private static HashMap<String, Movie> ourMovies;

    public static void initialize(String moviefile)  {
        if (ourMovies == null) {
            ourMovies = new HashMap<String,Movie>();
            loadMovies("data/" + moviefile);
        }
    }

    private static void initialize()  {
        if (ourMovies == null) {
            ourMovies = new HashMap<String,Movie>();
            loadMovies("data/ratedmoviesfull.csv");
        }
    }	

	
    private static void loadMovies(String filename){
    	FileResource fr = new FileResource(filename);
        CSVParser csvp = fr.getCSVParser();
        for(CSVRecord rec : csvp) {
                String id = rec.get("id");
                String title = rec.get("title");
                String year = rec.get("year");
                String country = rec.get("country");
                String genre = rec.get("genre");
                String diector = rec.get("director");
                int minutes = Integer.parseInt(rec.get("minutes"));
                String poster = rec.get("poster");
                Movie to_add_movie = new Movie(id, title, year, genre, diector, country, poster, minutes);
                ourMovies.put(id, to_add_movie);
        }
    }

    public static boolean containsID(String id){
        initialize();
        return ourMovies.containsKey(id);
    }

    public static int getYear(String id){
        initialize();
        return ourMovies.get(id).getYear();
    }

    public static String getGenres(String id){
        initialize();
        return ourMovies.get(id).getGenres();
    }

    public static String getTitle(String id){
        initialize();
        return ourMovies.get(id).getTitle();
    }

    public static Movie getMovie(String id){
        initialize();
        return ourMovies.get(id);
    }

    public static String getPoster(String id){
        initialize();
        return ourMovies.get(id).getPoster();
    }

    public static int getMinutes(String id){
        initialize();
        return ourMovies.get(id).getMinutes();
    }

    public static String getCountry(String id){
        initialize();
        return ourMovies.get(id).getCountry();
    }

    public static String getDirector(String id){
        initialize();
        return ourMovies.get(id).getDirector();
    }

    public static int size() {
        return ourMovies.size();
    }

    public static ArrayList<String> filterBy(Filter f){
        initialize();
        ArrayList<String> list = new ArrayList<String>();
        for(String id : ourMovies.keySet()) {
            if (f.satisfies(id)) {
                list.add(id);
            }
        }
        return list;
    }

}
