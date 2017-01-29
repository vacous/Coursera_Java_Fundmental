import java.util.Comparator;

public class title_and_depth_compartor implements Comparator<QuakeEntry> {

		public int compare(QuakeEntry entry_1, QuakeEntry entry_2) {
			String title_1 = entry_1.getInfo();
			String title_2 = entry_2.getInfo();
			int compare_result = title_1.compareTo(title_2);
//			System.out.println(compare_result);
			if ( compare_result == 0 )
			{
				double depth_1 = entry_1.getDepth();
				double depth_2 = entry_2.getDepth();
				compare_result = Double.compare(depth_1, depth_2);
			}
			return compare_result;
		}

}
