package naver_api;
/**
 * <pre>
 * naver_api 
 * Api.java
 *
 * 설명 :
 * </pre>
 * 
 * @since : 2020. 5. 31.
 * @author : zkook
 * @version : v1.0
 */
public class Api {
	//Scanner scan = new Scanner();
	Year ed = new Year();
	public static void main(String[] args) {
		String Q1 = null;
		String Q2 = null;
		String Q3 = null;
		String result = null;
		String year = null;
		int year1 = 0;
		int month1 = 0;
		int date1 = 0;
		int year2 = 0;
		int month2 = 0;
		int date2 = 0;
		
		String month = null;
		String date = null;
		String g = "20151127";
		String o = "20170301";
		result = g.substring(g.length()-8, g.length()-4);
		year = result;
		result = g.substring(g.length()-4, g.length()-2);
		month = result;
		result = g.substring(g.length()-2, g.length());
		date = result;
		date1 = Integer.parseInt(date);
		month1 = Integer.parseInt(month);
		year1  = Integer.parseInt(year);
		result = o.substring(g.length()-8, g.length()-4);
		year = result;
		result = o.substring(g.length()-4, g.length()-2);
		month = result;
		result = o.substring(g.length()-2, g.length());
		date = result;
		date2 = Integer.parseInt(date);
		month2 = Integer.parseInt(month);
		year2 = Integer.parseInt(year);
		int yw = Year.endDayFromTotalDay(year1,month1);
		int s = Year.totalDayFromCalendar(year2, month2, date2)-Year.totalDayFromCalendar(year1, month1, date1);
		for(int y = 0;y<s;y++) {
			if(date1 <= yw) {
				if(month1 >= 12) {
					year1++;
					month1 = 1;
					
				}
			
				
			}
				else {
					month1++;
					date1 = 1;
					if(month1 == 13) {
						month1 = 1;
					}
				}
			Q1 = Integer.toString(year1);
			Q2 = Integer.toString(month1);
			Q3 = Integer.toString(date1);
			System.out.println(Q1 + "-"+ Q2 + "-" + Q3);
			date1++;
			yw = Year.endDayFromTotalDay(year1,month1);
			
		}
	}
}  