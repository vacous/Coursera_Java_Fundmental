
public class GenreFilter implements Filter{
	private String myGenreName;
	public GenreFilter(String genre_name) {
		// TODO Auto-generated constructor stub
		myGenreName = genre_name;	
	}
	
	@Override
	public boolean satisfies(String id) {
		String[] all_genre = MovieDatabase.getGenres(id).split(", ");
		for(String each_genre: all_genre)
		{	
			if(each_genre.equals(myGenreName))
			{
				return true;
			}
		}
		return false;
	}
}
