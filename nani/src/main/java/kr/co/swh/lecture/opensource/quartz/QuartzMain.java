package kr.co.swh.lecture.opensource.quartz;

import java.util.UUID;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

import jsla.hohoh.SchedulerProcessor;

/**
 * <pre>
 * kr.co.swh.lecture.opensource.quartz
 * QuartzMain.java
 *
 * ���� :
 * </pre>
 * 
 * @since : 2018. 9. 30.
 * @author : tobby48
 * @version : v1.0
 */
public class QuartzMain {
	private StdSchedulerFactory schedulerFactory;
	private org.quartz.Scheduler scheduler;
	
	public QuartzMain(){
		schedulerFactory = new org.quartz.impl.StdSchedulerFactory();
		try {
			scheduler = schedulerFactory.getScheduler();
		} catch (SchedulerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean initialise(String cronExpr, Class<SchedulerProcessor> class1){
		String id = UUID.randomUUID().toString();
		
		JobDetail newJob = JobBuilder.newJob(class1).withIdentity(id).build();
		Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger_" + id)
				.withSchedule(CronScheduleBuilder.cronSchedule(cronExpr)).forJob(id)
				.build();
		if (trigger != null) {
			try {
				scheduler.scheduleJob(newJob, trigger);
			} catch (SchedulerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return true;
	}
	
	public void start(){
		try {
			scheduler.start();
		} catch (SchedulerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void stop(){
		try {
			if(schedulerFactory != null && scheduler.isStarted()){
				scheduler.shutdown();
			}
		} catch (SchedulerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QuartzMain quartz = new QuartzMain();
		
//		0/1 * * * * ?         �� 1�� ����
//		0 0/1 * * * ?         �� 1�� ����
//		0 0 0/1 * * ?         �� 1�ð� ����
//		0 0 0 * * ?            ���� 0�� ����
//		0 0 0 1 * ?            �ſ� 1�� ����
//		0 0 0 1,10,20 * ?    �ſ� 1��, 10��, 20�� ����
		
		if(quartz.initialise("0/1 * * * * ?", SchedulerProcessor.class)){
			quartz.start();
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			quartz.stop();
		}
	}
}