import java.util.ArrayList;
import java.util.HashSet;

public class test {
	public static void main(String[] args)
	{
//		//Week_03 quiz
//		RaterDatabase test_raterbase = new RaterDatabase();
//		MovieDatabase test_moviebase = new MovieDatabase();
//		RaterDatabase.initialize("ratings.csv");
//		MovieDatabase.initialize("ratedmoviesfull.csv");
//		DataAnalyzer test_analyzer = new DataAnalyzer(test_raterbase, test_moviebase);
//		System.out.println(test_analyzer.getAverageRatings(35).size());
//		System.out.println("=====================================");
//		YearAfterFilter test_year_filter = new YearAfterFilter(2000);
//		System.out.println(test_analyzer.getAverageRatingsWithFilter(20, test_year_filter).size());
//		System.out.println("=====================================");
//		GenreFilter test_genre_filter = new GenreFilter("Comedy");		
//		System.out.println(test_analyzer.getAverageRatingsWithFilter(20, test_genre_filter).size());
//		System.out.println("=====================================");
//		MinutesFilter minutesFilter = new MinutesFilter(105, 135);
//		System.out.println(test_analyzer.getAverageRatingsWithFilter(5, minutesFilter).size());
//		System.out.println("=====================================");
//		String[] test_directors = {"Clint Eastwood","Joel Coen","Martin Scorsese",
//				"Roman Polanski","Nora Ephron","Ridley Scott","Sydney Pollack"};
//		DirectorsFilter test_dfilter = new DirectorsFilter(test_directors);
//		System.out.println(test_analyzer.getAverageRatingsWithFilter(4, test_dfilter).size());
//		System.out.println("=====================================");
//		AllFilters all_01 = new AllFilters();
//		YearAfterFilter yearFilter_01 = new YearAfterFilter(1990);
//		GenreFilter genreFilter_01 = new GenreFilter("Drama");
//		all_01.addFilter(yearFilter_01);
//		all_01.addFilter(genreFilter_01);
//		System.out.println(test_analyzer.getAverageRatingsWithFilter(8, all_01).size());
//		System.out.println("=====================================");
//		AllFilters all_02 = new AllFilters();
//		MinutesFilter mintuesFilter_02 = new MinutesFilter(90, 180);
//		String[] director_02 = {"Clint Eastwood","Joel Coen","Tim Burton","Ron Howard","Nora Ephron","Sydney Pollack"};
//		DirectorsFilter directorFilter_02 = new DirectorsFilter(director_02);
//		all_02.addFilter(directorFilter_02);
//		all_02.addFilter(mintuesFilter_02);
//		System.out.println(test_analyzer.getAverageRatingsWithFilter(3, all_02).size());
//		System.out.println("=====================================");
		//week_04 quiz
//		RaterDatabase test_raterbase = new RaterDatabase();
//		MovieDatabase test_moviebase = new MovieDatabase();
//		RaterDatabase.initialize("ratings.csv");
//		MovieDatabase.initialize("ratedmoviesfull.csv");
//		DataAnalyzer test_analyzer = new DataAnalyzer(test_raterbase, test_moviebase);
//		System.out.println("=====================");
//		ArrayList<Rating> test_rating_01 = test_analyzer.getSimilarRatings("337", 10, 3);
//		System.out.println(MovieDatabase.getTitle(test_rating_01.get(0).getItem()));
//		System.out.println("=====================");
//		GenreFilter genreFilter_02 = new GenreFilter("Mystery");
//		ArrayList<Rating> test_rating_02 = test_analyzer.getSimilarRatingbyFilters("964", 20, 5, genreFilter_02);
//		System.out.println(MovieDatabase.getTitle(test_rating_02.get(0).getItem()));
//		System.out.println("=====================");
//		ArrayList<Rating> test_rating_03 = test_analyzer.getSimilarRatings("71", 20, 5);
//		System.out.println(MovieDatabase.getTitle(test_rating_03.get(0).getItem()));
//		System.out.println("=====================");
//		String[] input_directors = {"Clint Eastwood","J.J. Abrams"
//				,"Alfred Hitchcock","Sydney Pollack",
//				"David Cronenberg","Oliver Stone,Mike Leigh"};
//		DirectorsFilter directorFilter_04 = new DirectorsFilter(input_directors);
//		ArrayList<Rating> test_rating_04 = test_analyzer.getSimilarRatingbyFilters("120", 10, 2, directorFilter_04);
//		System.out.println(MovieDatabase.getTitle(test_rating_04.get(0).getItem()));
//		System.out.println("=====================");
//		MinutesFilter minutesFilter_05 = new MinutesFilter(80, 160);
//		ArrayList<Rating> test_rating_05 = test_analyzer.getSimilarRatingbyFilters("168", 10, 3, minutesFilter_05);
//		System.out.println(MovieDatabase.getTitle(test_rating_05.get(0).getItem()));
//		System.out.println("=====================");
//		AllFilters all_06 = new AllFilters();
//		MinutesFilter minutesFilter_06 = new MinutesFilter(70, 200);
//		YearAfterFilter year_06 = new YearAfterFilter(1975);
//		all_06.addFilter(minutesFilter_06);
//		all_06.addFilter(year_06);
//		ArrayList<Rating> test_rating_06 = test_analyzer.getSimilarRatingbyFilters("314", 10, 5, all_06);
//		System.out.println(MovieDatabase.getTitle(test_rating_06.get(0).getItem()));	
	}
}
