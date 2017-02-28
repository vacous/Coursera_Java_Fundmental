
public class MinutesFilter implements Filter{
	private int myMin;
	private int myMax;
	public MinutesFilter(int min_time, int max_time) {
		// TODO Auto-generated constructor stub
		myMin = min_time;
		myMax = max_time;
	}
	
	@Override
	public boolean satisfies(String id) {
		// TODO Auto-generated method stub
		return (MovieDatabase.getMinutes(id) >= myMin) && (MovieDatabase.getMinutes(id) <= myMax);
	}

}
