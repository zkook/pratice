package IpDisplay;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
/**
 * <pre>
 * IpDisplay 
 * URLEx2.java
 *
 * 설명 :
 * </pre>
 * 
 * @since : 2020. 5. 31.
 * @author : zkook
 * @version : v1.0
 */
public class URLEx2 {
    public static void main(String[] args) {
        try {
            URL url= new URL("http://swhacademy.ga:8081/sw_network/index.html"); 
            //  Case1 : URL방식
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
            
            //  Case2 : URLConnection방식 (HTTP POST방식으로 서버에 데이터를 전송)
//            URLConnection uc = url.openConnection();
//            BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream()));
            
            String inputLine;
            while ((inputLine = in.readLine()) != null) //  한 행씩 읽기
                System.out.println(inputLine);
            in.close();
        } catch (IOException e) {
            System.out.println("URL에서 데이터를 읽는 중 오류가 발생 했습니다.");
        }
    }
}

