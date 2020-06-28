package networking;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * <pre>
 * networking 
 * ThreadClient.java
 *
 * 설명 :
 * </pre>
 * 
 * @since : 2020. 6. 19.
 * @author : ZKOOK
 * @version : v1.0
 */

public class ThreadClient {
	
	private boolean getGame() {
		int count = 0;
		ArrayList<String> str = new ArrayList<String>();
		List<String> gameList = Arrays.asList("LeagueClientUxRender.exe", "Overwatch.exe", "Minecraft.exe",
				"Valant.exe", "MapleStory.exe");
		Process process;
		try {
			process = Runtime.getRuntime().exec("tasklist.exe");
			Scanner scanner = new Scanner(new InputStreamReader(process.getInputStream()));
			while (scanner.hasNext()) {
				String[] arr = scanner.nextLine().split(" ");
				str.add(arr[0]);
			}
			scanner.close();
			for (int i = 0; i < gameList.size(); i++) {
				if (str.contains(gameList.get(i))) {
					count ++;
				}
			}
			if(count > 0) return true;
			else return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	

	public static void main(String[] args) {
		ThreadClient threadclient = new ThreadClient();
		Scanner input = new Scanner(System.in);
		System.out.println("client");

		Socket CS = null;
		int count = 0;
		try {
			CS = new Socket();

			System.out.print("Login? (enter your NAME): ");
			String name = input.nextLine() + "0";
			CS.connect(new InetSocketAddress("192.168.0.171", 4040));
			byte[] as1 = name.getBytes("UTF-8");
			OutputStream OS1 = CS.getOutputStream();
			OS1.write(as1);
			System.out.println("SUCCESS");

			while (true) {
				Thread.sleep(10000);
				String message = "";;
				System.out.print("> ");
				if(threadclient.getGame()) message = "Yes";
				else message = "No";
				System.out.println(message);
				byte[] as = message.getBytes("UTF-8");
				OutputStream OS = CS.getOutputStream();
				OS.write(as);
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		try {
			CS.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}// MAIN
}
