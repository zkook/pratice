package jsla.jojo;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

/**
 * <pre>
 * kr.co.swh.lecture.opensource.log4j
 * LoggingService.java
 *
 * ���� :Log4j2 ����
 * </pre>
 * 
 * @since : 2018. 1. 31.
 * @author : tobby48
 * @version : v1.0
 */
public class LoggingService {
	static final Logger logger = LogManager.getLogger(LoggingService.class.getName());

	public boolean check() {
		
		if(logger.isErrorEnabled()){
			logger.error("������ �߻��߾��.");
		}
		if(logger.isDebugEnabled()){
			logger.debug("���װ� �߻��߾��.");
		}
		return false;
	}
}