package file_net.UDP; 

import java.io.FileOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * <pre>
 * kr.co.swh.lecture.network.filetrans 
 * FileReceiveServerUDP.java
 *
 * 설명 :파일 전송 서버
 * </pre>
 * 
 * @since : 2018. 12. 28.
 * @author : tobby48
 * @version : v1.0
 */
public class FileReceiveServerUDP {
	public static final int DEFAULT_BUFFER_SIZE = 10000;
	
	public static void main(String[] args) {
		int port =  9999;
		String filename = "D:\\hoh";

		long fileSize;
		long totalReadBytes = 0;

		byte[] buffer = new byte[DEFAULT_BUFFER_SIZE];
		try {
			int nReadSize = 0;
			System.out.println("Waitng.....");

			DatagramSocket ds = new DatagramSocket(port);
			FileOutputStream fos = null;       
			fos = new FileOutputStream(filename);
			
			//	start 신호 받는 파트
			DatagramPacket dp = new DatagramPacket(buffer, buffer.length);
			ds.receive(dp);		//	start 신호 받음
			String str = new String(dp.getData()).trim();

			if (str.equals("start")){
				System.out.println(str);
				
				//	파일의 크기 받는 파트
				dp = new DatagramPacket(buffer, buffer.length);
				ds.receive(dp);	//	파일의 크기 받음
				str = new String(dp.getData()).trim();
				fileSize = Long.parseLong(str);
				
				//	클라이언트로부터 파일의 내용을 받는 파트
				double startTime = System.currentTimeMillis(); 
				while (true) {
					ds.receive(dp);
					str = new String(dp.getData()).trim();
					nReadSize = dp.getLength();
					fos.write(dp.getData(), 0, nReadSize);
					
					//	진행률 출력
					totalReadBytes+=nReadSize;
					System.out.println("In progress: " + totalReadBytes + "/"
							+ fileSize + " Byte(s) ("
							+ (totalReadBytes * 100 / fileSize) + " %)");
					if(totalReadBytes>=fileSize)
						break;
				}
				double endTime = System.currentTimeMillis();
				double diffTime = (endTime - startTime)/ 1000;;
				double transferSpeed = (fileSize / 1000)/ diffTime;

				System.out.println("time: " + diffTime+ " second(s)");
				System.out.println("Average transfer speed: " + transferSpeed + " KB/s");
				System.out.println("File transfer completed");
				Thread.sleep(5000);
				fos.close();
				ds.close();
			}
			else{
				System.out.println("Start Error");
				fos.close();
				ds.close();
			}
		} catch (Exception e) {}
		System.out.println("Process Close");
	}
}