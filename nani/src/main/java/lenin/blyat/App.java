package lenin.blyat;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.text.Document;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
public class App 
{
    public static void main( String[] args )
    {
    	article art = new article();
    	Scanner Scan = new Scanner(System.in);
    	int sid1 = 100;
    	int sid2 = 269;
    	int days = 20191110;
    	int page = 1;
    	String str1;
    	System.out.println("문자열입력: ");
        str1 = Scan.nextLine();
    	try {
    		//웹에서 내용을 가져온다.
    		Document doc = (Document) Jsoup.connect("https://news.naver.com/main/list.nhn?sid1=100&sid2=269&mid=shm&mode=LS2D&date=20191110&page=1").get();
    		//내용 중에서 원하는 부분을 가져온다.
    		Elements contents = ((Element) doc).select("og:title");
    		//원하는 부분은 Elements형태로 되어 있으므로 이를 String 형태로 바꾸어 준다.
    		String text = contents.text();
    		System.out.println(text);
    		} catch (IOException e) { //Jsoup의 connect 부분에서 IOException 오류가 날 수 있으므로 사용한다.   

    		e.printStackTrace();

    		}
    }
}	
