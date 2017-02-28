
public class multipleRating extends Rating{
	private int myRatingnum;
	private String myItem;
	private double myRating;
	
	public multipleRating(String anItem, double aValue) {
		super(anItem, aValue);
		myItem = anItem;
		myRating = aValue;
		myRatingnum = 1;
	}
	
	public void addValue(double addition_value)
	{
		myRating += addition_value;
		myRatingnum += 1;
	}
	
	public double getAverage()
	{
		return myRating/myRatingnum;
	}
	
	public String getItem()
	{
		return myItem;
	}
	
	public String toString()
	{
		return (MovieDatabase.getTitle(myItem) + " : " + getAverage() + " : " + myRatingnum);
	}
	
	public int getRatingNum()
	{
		return myRatingnum;
	}
}
