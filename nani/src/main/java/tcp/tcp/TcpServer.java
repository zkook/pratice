package tcp.tcp; 

import java.sql.Connection;
import java.lang.annotation.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;



import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 * <pre>
 * tcp.tcp 
 * TcpServer.java
 *
 * 설명 :
 * </pre>
 * 
 * @since : 2020. 5. 31.
 * @author : zkook
 * @version : v1.0
 */
public class TcpServer {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://dev-swh.ga:3306/koko";

	static final String USERNAME = "root";
	static final String PASSWORD = "swhacademy!";
	public static void main(String[] args) {
		ServerSocket ss = null;		// ìì¼ìì±
		Socket sock = null;		// ìì¼
		
		try {
			ss = new ServerSocket(7000);	
			Connection connection = null;
			Statement statement = null;
			Gson gson = new GsonBuilder()
					.setLenient()
					.create();
			

			}


			/*
				String msg = in.readLine();
				System.out.println("ï¿½ï¿½ï¿½ï¿½ ï¿½Þ½ï¿½ï¿½ï¿½ : "+msg);

				Å¬ï¿½ï¿½ï¿½Ì¾ï¿½Æ®ï¿½ï¿½ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½
				in.close();
				sock.close();*/

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}