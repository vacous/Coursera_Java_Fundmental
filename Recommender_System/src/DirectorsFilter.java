import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DirectorsFilter implements Filter{
	private Set<String> myDirector;
	public DirectorsFilter(String[] input_director) {
		// TODO Auto-generated constructor stub
		myDirector = new HashSet<String>(Arrays.asList(input_director));
	}

	@Override
	public boolean satisfies(String id) {
		// TODO Auto-generated method stub
		String[] all_directors = MovieDatabase.getDirector(id).split(", ");
		for(String each_director: all_directors)
		{
			if(myDirector.contains(each_director))
			{
				return true;
			}
		}
		return false;
	}

}
