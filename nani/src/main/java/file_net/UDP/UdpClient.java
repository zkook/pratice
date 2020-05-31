package file_net.UDP; 

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/**
 * <pre>
 * kr.co.swh.lecture.network.udp
 * UdpClient.java
 *
 * ���� :UDP Ŭ���̾�Ʈ
 * </pre>
 * 
 * @since : 2018. 6. 23.
 * @author : zkook
 * @version : v1.0
 */
public class UdpClient {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("���� �޼��� �Է� :");
		String msg = scanner.next();
		try{
			// ������ �� �ִ� UDP ���� ����
			DatagramSocket ds = new DatagramSocket();

			// ���� ���� �ּ� ����
			InetAddress ia = InetAddress.getByName("127.0.0.1");

			// ������ ������ ����
			DatagramPacket dp = new DatagramPacket(msg.getBytes(),msg.getBytes().length,ia, 7777);

			//������ ����
			ds.send(dp);
			ds.close();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		scanner.close();
	}
}