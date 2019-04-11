package generic;

import java.util.ArrayList;
import java.util.List;
public class TestGeneric04 {
	
	public static void sort(
	  List<? extends Object> lst){}

	public static void main(String[] args) {
		List<? extends Object> list1=
		new ArrayList<String>();
		
		System.out.println(list1.size());
		List<? super String> list2=
		new ArrayList<CharSequence>();
		
		List<String> list3=new ArrayList<String>();
		sort(list3);
	}
}
