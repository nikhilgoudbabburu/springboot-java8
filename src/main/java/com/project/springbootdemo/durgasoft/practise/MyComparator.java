package com.project.springbootdemo.durgasoft.practise;

import java.util.Comparator;

public class MyComparator implements Comparator<Integer>{

	@Override
	public int compare(Integer o1, Integer o2) {
		// TODO Auto-generated method stub
		if(o1<o2)
			return 1;
		if(o1>o2)
			return -1;
		return 0;
		
		//we can do above way or below
//		return o1.compareTo(o2); //ascending order
		
//		return o2.compareTo(o1); descending order
	}
	
}
