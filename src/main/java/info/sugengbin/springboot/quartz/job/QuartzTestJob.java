package info.sugengbin.springboot.quartz.job;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.PersistJobDataAfterExecution;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;

import info.sugengbin.springboot.biz.QuartzTestService;

/**
 * 
 *
 * Date: 2017年2月22日<br/>
 * 
 * @author sugengbin
 */
@PersistJobDataAfterExecution
@DisallowConcurrentExecution
public class QuartzTestJob extends QuartzJobBean {

	private final static Logger logger = LoggerFactory.getLogger(QuartzTestJob.class);

	private QuartzTestService quartzTestService = null;

	/**
	 * 
	 * @param context
	 */
	protected void init(JobExecutionContext context) {
		final JobDataMap jobDataMap = context.getMergedJobDataMap();
		quartzTestService = (QuartzTestService) jobDataMap.get("quartzTestService");
	}

	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		init(context);
		quartzTestService.run();
	}

}
