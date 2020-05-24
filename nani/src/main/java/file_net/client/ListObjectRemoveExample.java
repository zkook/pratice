package file_net.client;
import java.util.ArrayList;

import java.util.HashMap;

import java.util.List;

 

public class ListObjectRemoveExample {

	

	public static void main(String[] args) {

		HashMap<String, Integer> map = new HashMap<String, Integer>();	

		

//		if(!map.containsKey("서울")) {

//			map.put("서울", 1);

//		}else {

//			map.put("서울", map.get("서울") + 1); 

//		}

//		

//		String[] sList = {"서울", "광주", "서울"};

//		서울, 1

//		광주, 1

//		서울, 2

		

		

		List<WordCloud> list = new ArrayList<WordCloud>();

		WordCloud w1 = new WordCloud("코딩", 1);

		list.add(w1);

		WordCloud w2 = new WordCloud("코딩", 2);

		list.remove(w2);

		list.add(w2);

		

		

		System.out.println(w1.equals(w2));

		System.out.println(list.size());

		System.out.println(list.get(0).getSize());

	}

}