package HTTPCLIENT;

import java.io.IOException;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * <pre>
 * HTTPCLIENT 
 * HttpClientDeleteExample.java
 *
 * 설명 :
 * </pre>
 * 
 * @since : 2020. 5. 31.
 * @author : zkook
 * @version : v1.0
 */
public class HttpClientDeleteExample {
    public static void main(String[] args) {
        HttpClient client = HttpClients.createDefault();
        HttpDelete request = new HttpDelete("주소");
        try {
            //  삭제 요청
            HttpResponse response = client.execute(request);
            
            //  응답
            String result = EntityUtils.toString(response.getEntity());
            System.out.println(result);
        } catch (IOException e2) {
            // TODO Auto-generated catch block
            e2.printStackTrace();
        } 
    }
}