package quartz; 

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;


/**
 * <pre>
 * kr.co.swh.lecture.opensource.quartz 
 * SchedulerProcessor.java
 *
 * 설명 :
 * </pre>
 * 
 ** @since : 2019. 7. 30.
 * @author : zkook
 * @version : v1.0
 */
public class SchedulerProcessor implements quartz.Job{
	private static int count = 0;
	public void execute(JobExecutionContext context) throws JobExecutionException {
		// TODO Auto-generated method stub
		System.out.println(++count + "돈다");
		try {
			Thread.sleep(900);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(count + "끝났다");
	}
}