package corona.mask;

import static spark.Spark.get;
import static spark.Spark.port;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;
import static spark.Spark.get;
import static spark.Spark.modelAndView;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.google.gson.Gson;




/**
 * <pre>
 * corona.mask 
 * main.java
 *
 * 설명 :
 * </pre>
 * 
 * @since : 2020. 5. 31.
 * @author : zkook
 * @version : v1.0
 */
public class main {
	
	public static void main(String args[]) throws IOException {

		get("/mask", (request, response) -> {
			Map<String, Object> attributes = new HashMap<>();
			attributes.put("message", "Hello FreeMarker World");

			// The hello.ftl file is located in directory:
			// src/test/resources/spark/examples/templateview/freemarker
			return modelAndView(attributes, "mask.ftl");
		}, new FreeMarkerTemplateEngine());
		
		





	}

}
