
/**
 * Write a description of class DifferentSorters here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;

public class DifferentSorters {
	public void sort_by_title_and_depth()
	{
		EarthQuakeParser input_parser = new EarthQuakeParser();
		String source = "C:/Users/Administrator/Desktop/新建文件夹/data/earthQuakeDataWeekDec6sample2.atom";
		ArrayList<QuakeEntry> list  = input_parser.read(source);
		Collections.sort(list, new title_and_depth_compartor());
        int counter = 0;
        for(QuakeEntry qe: list) {
        	counter += 1;
        	if ( counter == 501)
        	{
        		System.out.println(qe);
        	}
        }
	}
	
	public void sort_by_last_word_in_title_magnitude()
	{
		EarthQuakeParser input_parser = new EarthQuakeParser();
		String source = "C:/Users/Administrator/Desktop/新建文件夹/data/earthQuakeDataWeekDec6sample1.atom";
		ArrayList<QuakeEntry> list  = input_parser.read(source);
		Collections.sort(list, new title_last_and_magnitude_comparator());
        int counter = 0;
        for(QuakeEntry qe: list) {
        	counter += 1;
        	if ( counter == 501)
        	{
        		System.out.println(qe);
        	}
        }
	}
	
	
	
    public void sortWithCompareTo() {
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "C:/Users/Administrator/Desktop/新建文件夹/data/earthQuakeDataWeekDec6sample1.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        Collections.sort(list, new MagnitudeComparator() );
        int counter = 0;
        for(QuakeEntry qe: list) {
        	counter += 1;
        	if ( counter == 601)
        	{
        		System.out.println(qe);
        	}
        }

    }    

    public void sortByMagnitude() {
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "data/nov20quakedata.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        Collections.sort(list, new MagnitudeComparator());
        for(QuakeEntry qe: list) {
            System.out.println(qe);
        }

    }

    public void sortByDistance() {
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "data/nov20quakedata.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        // Location is Durham, NC
        Location where = new Location(35.9886, -78.9072);
        Collections.sort(list, new DistanceComparator(where));
        for(QuakeEntry qe: list) {
            System.out.println(qe);
        }

    }
}
