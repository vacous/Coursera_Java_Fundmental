import java.util.Comparator;

public class title_last_and_magnitude_comparator implements Comparator<QuakeEntry>{
	public int compare(QuakeEntry entry_01, QuakeEntry entry_02)
	{
		String[] word_array_1 = entry_01.getInfo().split(" ");
		String[] word_array_2 = entry_02.getInfo().split(" ");
		String word_1 = word_array_1[word_array_1.length - 1];
		String word_2 = word_array_2[word_array_2.length - 1];
		int compare_result = word_1.compareTo(word_2);
		if ( compare_result == 0 )
		{
			double magnitude_1 = entry_01.getMagnitude();
			double magnitude_2 = entry_02.getMagnitude();
			compare_result = Double.compare(magnitude_1, magnitude_2);
		}
		return compare_result;
	}

}
