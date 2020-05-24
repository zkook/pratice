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

public class TcpServer {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://dev-swh.ga:3306/koko";

	static final String USERNAME = "root";
	static final String PASSWORD = "swhacademy!";
	public static void main(String[] args) {
		ServerSocket ss = null;		// 소켓생성
		Socket sock = null;		// 소켓
		
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
				System.out.println("���� �޽��� : "+msg);

				Ŭ���̾�Ʈ���� ���� ����
				in.close();
				sock.close();*/

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}