
/**
 * Write a description of class QuakeSortInPlace here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.lang.reflect.Array;
import java.util.*;
import edu.duke.*;

public class QuakeSortInPlace {
    public QuakeSortInPlace() {
        // TODO Auto-generated constructor stub
    }
   
    public int getSmallestMagnitude(ArrayList<QuakeEntry> quakes, int from) {
        int minIdx = from;
        for (int i=from+1; i< quakes.size(); i++) {
            if (quakes.get(i).getMagnitude() < quakes.get(minIdx).getMagnitude()) {
                minIdx = i;
            }
        }
        return minIdx;
    }
    
    public int get_largest_depth(ArrayList<QuakeEntry> quake_data, int start_idx)
    {
    	double largest_depth = -Double.MAX_VALUE;
    	int the_idx = -1;
    	for ( int idx = start_idx; idx< quake_data.size(); idx += 1)
    	{
    		QuakeEntry each_entry = quake_data.get(idx);
    		double current_depth = each_entry.getDepth();
    		if ( current_depth > largest_depth)
    		{
    			largest_depth = current_depth;
    			the_idx = idx;
    		}
    	}
    	return the_idx; 
    }
    
    
    public void sort_by_largest_depth(ArrayList<QuakeEntry> input_array)
    {
    	for (int idx = 0; idx < 70; idx += 1)
    	{
    		int idx_max = get_largest_depth(input_array, idx);
    		QuakeEntry max_entry = input_array.get(idx_max);
    		QuakeEntry head_entry = input_array.get(idx);
    		input_array.set(idx, max_entry);
    		input_array.set(idx_max, head_entry);
    	}
    	
    }
    
    
    public void sortByMagnitude(ArrayList<QuakeEntry> in) {
       
       for (int i=0; i< in.size(); i++) {
            int minIdx = getSmallestMagnitude(in,i);
            QuakeEntry qi = in.get(i);
            QuakeEntry qmin = in.get(minIdx);
            in.set(i,qmin);
            in.set(minIdx,qi);
        }
        
    }

    public void testSort() {
        EarthQuakeParser parser = new EarthQuakeParser(); 
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        String source = "C:/Users/Administrator/Desktop/新建文件夹/data/earthQuakeDataWeekDec6sample1.atom";
        //String source = "data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);  
       
        System.out.println("read data for "+ list.size() +" quakes"); 
        System.out.println("==========================");
//        sortByMagnitude(list);
//
//        sort_by_largest_depth(list);

//        
        sort_by_magnitude_with_bubble_sort_with_check(list);
//        sort_by_magnitude_with_check(list);
        
//        result_printer(list);
        System.out.println("==========================");
//        }
        
    }
    
    public void one_pass_bubble_sort(ArrayList<QuakeEntry> input_entry, int num_sorted)
    {	
    	int total_length = input_entry.size();
    	for (int idx = 0; idx < total_length - num_sorted - 1; idx += 1)
    	{
    		QuakeEntry first_entry = input_entry.get(idx);
    		QuakeEntry second_entry = input_entry.get(idx+1);
    		double first_magnitude = first_entry.getMagnitude();
    		double second_magnitude = second_entry.getMagnitude();
    		if ( second_magnitude < first_magnitude)
    		{
    			input_entry.set(idx+1, first_entry);
    			input_entry.set(idx, second_entry);
    		}
    	}

    }
    
    public void sort_by_magnitude_with_bubble_sort(ArrayList<QuakeEntry> input_entry)
    {
    	
    	
    	for (int idx = 0; idx < input_entry.size(); idx += 1)
    	{
//    		result_printer(input_entry);
//    		System.out.println("_____________________");
    		one_pass_bubble_sort(input_entry, idx);
    	}
    }
    
    public boolean check_in_sorted_order(ArrayList<QuakeEntry> input_array)
    {
    	for (int idx = 0; idx < input_array.size() - 1; idx += 1)
    	{
    		QuakeEntry first_entry = input_array.get(idx);
    		QuakeEntry second_entry = input_array.get(idx+1);
    		double first_magnitude = first_entry.getMagnitude();
    		double second_magenitude = second_entry.getMagnitude();
    		if ( second_magenitude < first_magnitude)
    		{
    			return false;
    		}
    	}
    	return true;
    }
    
    
    public void sort_by_magnitude_with_bubble_sort_with_check(ArrayList<QuakeEntry> input_array)
    {	
    	int idx = 0;
    	while ( !check_in_sorted_order(input_array))
    	{
    		one_pass_bubble_sort(input_array, idx);
    		idx += 1;
    	}
    	System.out.println(idx);
    }
    
    public void sort_by_magnitude_with_check(ArrayList<QuakeEntry> in){
        for (int i=0; i< in.size(); i++) {
        	if (check_in_sorted_order(in))
            {
        		System.out.println(i);
        		break;
            }
             int minIdx = getSmallestMagnitude(in,i);
             QuakeEntry qi = in.get(i);
             QuakeEntry qmin = in.get(minIdx);
             in.set(i,qmin);
             in.set(minIdx,qi);
             
             
         }
         
     }
    
    
    
    public void createCSV() {
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "data/nov20quakedata.atom";
        String source = "data/nov20quakedatasmall.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        dumpCSV(list);
        System.out.println("# quakes read: " + list.size());
    }
    
    public void dumpCSV(ArrayList<QuakeEntry> list) {
		System.out.println("Latitude,Longitude,Magnitude,Info");
		for(QuakeEntry qe : list){
			System.out.printf("%4.2f,%4.2f,%4.2f,%s\n",
			                  qe.getLocation().getLatitude(),
			                  qe.getLocation().getLongitude(),
			                  qe.getMagnitude(),
			                  qe.getInfo());
	    }
		
	}
    
    public void result_printer(ArrayList<QuakeEntry> input_array)
    {	
    	for (QuakeEntry each_entry: input_array)
    	{
    		System.out.println(each_entry);
    	}
    }
}
