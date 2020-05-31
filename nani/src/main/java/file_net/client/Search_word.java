package file_net.client;
import static spark.Spark.*;
import java.sql.Connection;
import java.lang.annotation.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bitbucket.eunjeon.seunjeon.Analyzer;
import org.bitbucket.eunjeon.seunjeon.LNode;
import org.bitbucket.eunjeon.seunjeon.Morpheme;

import com.google.gson.Gson;

import corona.mask.FreeMarkerTemplateEngine;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;

/**
 * <pre>
 * file_net.client 
 * Search_word.java
 *
 * 설명 :
 * </pre>
 * 
 * @since : 2020. 5. 31.
 * @author : zkook
 * @version : v1.0
 */
public class Search_word {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://dev-swh.ga:3306/kassava12";
	static final String USERNAME = "root";
	static final String PASSWORD = "swhacademy!";
	public static void main(String[] args) {
		port(7777);	
		get("/blog/:id", (request, response) -> {
			Connection connection = null;
			Statement stmt = null;			

			response.type("application/json");
			Class.forName(JDBC_DRIVER);			
			connection = DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
			System.out.println("MariaDB 연결.");									
			stmt = connection.createStatement();
			String i = request.params(":id");		
			if (i == null) {					
				response.status(404); // 404 Not found
				return "Book not found";				
			}			

			//형태소 분석
			/*map<String, Object> anal = new HashMap<>();*/	
			/*for (LNode node : Analyzer.parseJava(i)) {
				Morpheme m = node.morpheme();
				System.out.println(m.surface() + " / 품사:" + m.feature().head());
			}*/
			String y = "SELECT * FROM Blog where title like '%"+ i +"%'";
			ResultSet pop = stmt.executeQuery(y);
			ArrayList<Blog> list = new ArrayList<Blog>();
			List<Word> list_a = new ArrayList<Word>();
			while(pop.next()) {
				Blog a = new Blog();
				a.setTitle(pop.getString("title"));
				a.setDescription(pop.getString("description"));

				for (LNode node : Analyzer.parseJava(a.getDescription())) {
					Morpheme m = node.morpheme();
					if (m.feature().head().equals("NNG") || m.feature().head().equals("NNP")){
						
						String gaga = m.surface();
						Word w1 = new Word();
						list_a.add(w1);
					}
					//System.out.println(m.surface() + " / 품사:" + m.feature().head());
				}

				List<Word> list1 = new ArrayList<Word>();


				list.add(a);
			}		

			String list1 = new Gson().toJson(list);
			return list1;



		});







		get("/blog/", (request, response) -> {
			Connection connection = null;
			Statement stmt = null;			

			response.type("application/json");
			Class.forName(JDBC_DRIVER);			
			connection = DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
			System.out.println("MariaDB 연결.");									
			stmt = connection.createStatement();
			//String i = request.params(":id");		
			//if (i == null) {					
			//	response.status(404); // 404 Not found
			//	return "Book not found";				
			//}			
			String y = "SELECT * FROM Blog";
			ResultSet pop = stmt.executeQuery(y);
			ArrayList<Blog> list = new ArrayList<Blog>();
			while(pop.next()) {
				Blog a = new Blog();
				a.setTitle(pop.getString("title"));
				a.setDescription(pop.getString("description"));


				list.add(a);
			}		
			Map<String, Object> attributes = new HashMap<>();
			attributes.put("i", list);
			//String list1 = new Gson().toJson(list);
			//return list1;
			response.type("text/html");
			return modelAndView(attributes, "Blog.ftl");

		}, new FreeMarkerTemplateEngine());
		//은전한닢
		for (LNode node : Analyzer.parseJava("")) {
			Morpheme m = node.morpheme();
			System.out.println(m.surface() + " / 품사:" +m.feature().head());


		}



		get("/blog/", (request, response) -> {
			Connection connection = null;
			Statement stmt = null;			

			response.type("application/json");
			Class.forName(JDBC_DRIVER);			
			connection = DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
			System.out.println("MariaDB 연결.");									
			stmt = connection.createStatement();
			//String i = request.params(":id");		
			//if (i == null) {					
			//	response.status(404); // 404 Not found
			//	return "Book not found";				
			//}fuck!
			String y = "SELECT * FROM Blog";
			ResultSet pop = stmt.executeQuery(y);
			ArrayList<Blog> list = new ArrayList<Blog>();
			while(pop.next()) {
				Blog a = new Blog();
				a.setTitle(pop.getString("title"));
				a.setDescription(pop.getString("description"));


				list.add(a);
			}		
			Map<String, Object> attributes = new HashMap<>();
			attributes.put("i", list);

			response.type("text/html");
			return modelAndView(attributes, "Blog.ftl");

		});



	}

}
