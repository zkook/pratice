package jsla.jojo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * <pre>
 * kr.co.swh.lecture.opensource.log4j
 * Log4jMain.java
 *
 * ���� :Log4j2 ����
 * </pre>
 * 
 * @since : 2018. 1. 31.
 * @author : tobby48
 * @version : v1.0
 */
public class Log4jMain {

	private static final Logger logger = LogManager.getLogger(Log4jMain.class.getName());

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		logger.trace("Entering application.");
		LoggingService bar = new LoggingService();
		if (!bar.check()) {
			logger.error("Didn't do it.");
		}
		logger.trace("Exiting application.");

		logger.fatal("[{}] �α׸� ����մϴ�.", "FATAL");
		logger.error("[{}] �α׸� ����մϴ�.", "ERROR");
		logger.warn("[{}] �α׸� ����մϴ�.", "WARN");
		logger.info("[{}] �α׸� ����մϴ�.", "INFO");
		logger.debug("[{}] �α׸� ����մϴ�.", "DEBUG");
		logger.trace("[{}] �α׸� ����մϴ�.", "TRACE");
	}

}