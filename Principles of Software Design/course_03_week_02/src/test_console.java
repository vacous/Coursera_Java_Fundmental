import java.util.ArrayList;

public class test_console {
	public static void main(String[] args)
	{
		String quiz_source = "http://www.dukelearntoprogram.com/course4/data/earthquakeDataSampleSix1.atom";
		EarthQuakeParser test_parser = new EarthQuakeParser();
		ArrayList<QuakeEntry> test_entry_array = test_parser.read(quiz_source);
		QuakeSortInPlace test_place = new QuakeSortInPlace();
//		test_place.sort_by_largest_depth(test_entry_array);
//		test_place.result_printer(test_entry_array);
		test_place.testSort();
	}
}
