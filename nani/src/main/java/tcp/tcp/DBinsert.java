package tcp.tcp;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.nio.charset.Charset;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * <pre>
 * tcp.tcp 
 * DBinsert.java
 *
 * 설명 :
 * </pre>
 * 
 * @since : 2020. 5. 31.
 * @author : zkook
 * @version : v1.0
 */
public class DBinsert {
	public DBinsert(JDBC_DRIVER,DB_URL,USERNAME,PASSWORD){
		
	}
	public void insert(){
		try{
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
			System.out.println("MariaDB 접속.");
			statement = connection.createStatement();
			while (true) {
				sock = ss.accept();
				
				//BufferedReader in = new BufferedReader(new InputStreamReader(sock.getInputStream(), Charset.forName("UTF-8")));
				DataInputStream dis  = new DataInputStream(new BufferedInputStream(sock.getInputStream()));
				int len;
				byte[] data = new byte[4096];
				while ((len = dis.read(data)) != -1) {
					String Pop = new String(data, Charset.forName("UTF-8"));
					Pop = Pop.trim();	//	�¿� ��������
					System.out.println(Pop);
					blog Script = gson.fromJson(Pop, blog.class);
					String ad = "insert into Blog(title,description) values('"+ Script.title +"','"+ Script.description +"');";
		
					try {
						boolean result = statement.execute(ad);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						//e.printStackTrace();
					}

				}
				dis.close();
				sock.close();
			}

		}catch(SQLException se1){
			se1.printStackTrace();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
}

