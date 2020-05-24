package corona.mask;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;



public class send {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://dev-swh.ga:3306/koko";
	static final String USERNAME = "root";
	static final String PASSWORD = "swhacademy!";
	public static void main(String args[]) throws IOException {
		HttpClient client = HttpClients.createDefault();
		HttpGet Hc = new HttpGet("https://8oi9s0nnth.apigw.ntruss.com/corona19-masks/v1/stores/json?page=1&perPage=500");

		//		for(int i = 0; i > 500; i++) {
		try {
			Class.forName(JDBC_DRIVER);
			Connection connection = DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
			Statement statement = null;
			statement = connection.createStatement();
			
			
			HttpResponse response = client.execute(Hc);
			HttpEntity entity = response.getEntity();
			String result = EntityUtils.toString(entity);
			//System.out.println(result);
			Gson gson = new Gson();
			name nm = gson.fromJson(result, name.class);
			List<location> k = nm.getStoreInfos();
			String ad;
			for(int i = 0; i < k.size(); i++) {
				System.out.println();
				ad = "insert into Blog(title,description) values('"+ k.get(i).getAddr() +"','"+ k.get(i).getCode() +"');";
				try {
					boolean result2 = statement.execute(ad);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
				}
			}
	
			
			//System.out.println(result);
		} catch (IOException e2) {
			System.out.println("nope");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}



		
		
	}
}
















